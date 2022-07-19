package com.github.tvbox.osc.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.github.tvbox.osc.R;
import com.github.tvbox.osc.event.RefreshEvent;
import com.github.tvbox.osc.server.ControlManager;
import com.github.tvbox.osc.ui.adapter.ApiHistoryDialogAdapter;
import com.github.tvbox.osc.ui.tv.QRCodeGen;
import com.github.tvbox.osc.util.HawkConfig;
import com.hjq.permissions.OnPermissionCallback;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;
import com.orhanobut.hawk.Hawk;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import me.jessyan.autosize.utils.AutoSizeUtils;

/**
 * 频道名配置
 */
public class ChannelHintDialog extends BaseDialog {
    private TextView tvChannelHint;
    private EditText inputChannelHint;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refresh(RefreshEvent event) {
    }

    public ChannelHintDialog(@NonNull @NotNull Context context) {
        super(context);
        setContentView(R.layout.dialog_channel_hint);
        setCanceledOnTouchOutside(false);
        tvChannelHint = findViewById(R.id.tvChannelHint);
        StringBuilder sb = new StringBuilder();
        sb.append("直播频道名配置说明:\n");
        sb.append("%n - 频道名\n");
        sb.append("%c - 频道号\n");
        sb.append("%s - 源序号\n");
        sb.append("%a - 源数量\n");
        tvChannelHint.setText(sb.toString());

        inputChannelHint = findViewById(R.id.input);
        inputChannelHint.setText(Hawk.get(HawkConfig.CHANNEL_HINT, ""));
        findViewById(R.id.inputSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newChannelHint = inputChannelHint.getText().toString().trim();
                if (!newChannelHint.isEmpty()) {
                    listener.onchange(newChannelHint);
                    dismiss();
                }
            }
        });
    }

    public void setOnListener(OnListener listener) {
        this.listener = listener;
    }

    OnListener listener = null;

    public interface OnListener {
        void onchange(String api);
    }
}
