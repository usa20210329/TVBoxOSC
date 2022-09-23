package com.github.tvbox.osc.util;

import java.util.Locale;

public class StorageDriveType {

    public enum TYPE {
        LOCAL,
        WEBDAV,
        ALISTWEB,
        //SMB
    }

    public static String[] getTypeNames() {
        return new String[] {
                "本地目录",
                "Webdav",
                "Alist网页"
                //"服务器消息块"
        };
    }

    public static boolean isVideoType(String type) {
        if(type == null || type.length() == 0)
            return false;
        type = type.toUpperCase(Locale.ROOT).trim();
        for (String videoType : videoTypes) {
            if(videoType.equals(type))
                return true;
        }
        return false;
    }

    private static final String[] videoTypes = new String[] {
            "264",
            "264",
            "3G2",
            "3GP",
            "3GP2",
            "3GPP",
            "3GPP2",
            "3MM",
            "3P2",
            "60D",
            "787",
            "89",
            "AEC",
            "AEGRAPHIC",
            "AEP",
            "AEPX",
            "AET",
            "AETX",
            "AJP",
            "ALE",
            "ALPX",
            "AM",
            "AMC",
            "AMV",
            "AMX",
            "ANIM",
            "ANM",
            "ANX",
            "ANYDESK",
            "AQT",
            "ARCUT",
            "ARF",
            "ASF",
            "ASX",
            "AV",
            "AV1",
            "AV3",
            "AVB",
            "AVC",
            "AVCHD",
            "AVD",
            "AVE",
            "AVI",
            "AVM",
            "AVP",
            "AVR",
            "AVS",
            "AVS",
            "AVS",
            "AVV",
            "AWLIVE",
            "AXM",
            "AXV",
            "BDM",
            "BDMV",
            "BDT2",
            "BDT3",
            "BIK",
            "BIK2",
            "BIX",
            "BK2",
            "BLZ",
            "BMC",
            "BMK",
            "BNP",
            "BS4",
            "BSF",
            "BU",
            "BVR",
            "BYU",
            "CAM",
            "CAMPROJ",
            "CAMREC",
            "CAMTEMPLATE",
            "CAMV",
            "CDXL",
            "CED",
            "CEL",
            "CINE",
            "CIP",
            "CLK",
            "CLPI",
            "CME",
            "CMMP",
            "CMMTPL",
            "CMPROJ",
            "CMREC",
            "CMV",
            "CPI",
            "CPVC",
            "CREC",
            "CST",
            "CVC",
            "CX3",
            "D2V",
            "D3V",
            "DAD",
            "DASH",
            "DAT",
            "DAV",
            "DB2",
            "DCE",
            "DCK",
            "DCR",
            "DCR",
            "DDAT",
            "DIF",
            "DIR",
            "DIVX",
            "DLX",
            "DMB",
            "DMSD",
            "DMSD3D",
            "DMSM",
            "DMSM3D",
            "DMSS",
            "DMX",
            "DNC",
            "DPA",
            "DPG",
            "DRC",
            "DREAM",
            "DRP",
            "DSY",
            "DV",
            "DV-AVI",
            "DV4",
            "DVDMEDIA",
            "DVR",
            "DVR-MS",
            "DVX",
            "DXR",
            "DZM",
            "DZP",
            "DZT",
            "EDL",
            "EL8",
            "EVO",
            "EVO",
            "EXI",
            "EXO",
            "EXP",
            "EYE",
            "EYETV",
            "EZT",
            "F4F",
            "F4M",
            "F4P",
            "F4V",
            "FBR",
            "FBR",
            "FBZ",
            "FCARCH",
            "FCP",
            "FCPROJECT",
            "FFD",
            "FFM",
            "FLC",
            "FLH",
            "FLI",
            "FLIC",
            "FLV",
            "FLX",
            "FPDX",
            "FTC",
            "FVM",
            "FVT",
            "G2M",
            "G64",
            "G64X",
            "GCS",
            "GFP",
            "GIFV",
            "GL",
            "GOM",
            "GRASP",
            "GTS",
            "GVI",
            "GVP",
            "GXF",
            "H261",
            "H262",
            "H263",
            "H264",
            "H265",
            "HDMOV",
            "HDV",
            "HEVC",
            "HKM",
            "IMOVIELIBRARY",
            "IMOVIEMOBILE",
            "IMOVIEPROJ",
            "IMOVIEPROJECT",
            "INP",
            "INSV",
            "INT",
            "IRCP",
            "IRF",
            "ISM",
            "ISMC",
            "ISMCLIP",
            "ISMV",
            "IVA",
            "IVF",
            "IVR",
            "IVS",
            "IZZ",
            "IZZY",
            "JDR",
            "JMV",
            "JNR",
            "JSS",
            "JTS",
            "JTV",
            "JV",
            "K3G",
            "KDENLIVE",
            "KINE",
            "KMPROJECT",
            "KMV",
            "KTN",
            "KUX",
            "LFPACKAGE",
            "LREC",
            "LRV",
            "LSF",
            "LSX",
            "LVF",
            "LVIX",
            "LXF",
            "M15",
            "M1PG",
            "M1V",
            "M21",
            "M21",
            "M2A",
            "M2P",
            "M2T",
            "M2TS",
            "M2V",
            "M4E",
            "M4F",
            "M4S",
            "M4U",
            "M4V",
            "M75",
            "MANI",
            "MEDIA",
            "MEP",
            "MEPS",
            "MEPX",
            "META",
            "MGV",
            "MJ2",
            "MJP",
            "MJPEG",
            "MJPG",
            "MK3D",
            "MKV",
            "ML20",
            "MMP",
            "MMV",
            "MNV",
            "MOB",
            "MOD",
            "MODD",
            "MOFF",
            "MOI",
            "MOOV",
            "MOV",
            "MOVIE",
            "MOVIE",
            "MOVIE",
            "MP21",
            "MP21",
            "MP2V",
            "MP4",
            "MP4",
            "MP4V",
            "MP5",
            "MPC",
            "MPE",
            "MPEG",
            "MPEG1",
            "MPEG2",
            "MPEG4",
            "MPF",
            "MPG",
            "MPG2",
            "MPG4",
            "MPGINDEX",
            "MPL",
            "MPL",
            "MPLS",
            "MPROJ",
            "MPSUB",
            "MPV",
            "MPV2",
            "MQV",
            "MSDVD",
            "MSE",
            "MSH",
            "MSWMM",
            "MT2S",
            "MTS",
            "MTV",
            "MV",
            "MV8",
            "MVB",
            "MVC",
            "MVD",
            "MVE",
            "MVEX",
            "MVI",
            "MVP",
            "MVP",
            "MVY",
            "MXV",
            "MYS",
            "N3R",
            "NCOR",
            "NFV",
            "NSV",
            "NTP",
            "NUT",
            "NUV",
            "NVC",
            "OGM",
            "OGV",
            "OGX",
            "ORV",
            "OTRKEY",
            "P64",
            "PAC",
            "PAF",
            "PAR",
            "PCLX",
            "PDRPROJ",
            "PDS",
            "PEG",
            "PGI",
            "PHOTOSHOW",
            "PIC",
            "PIV",
            "PJR",
            "PJS",
            "PLAYLIST",
            "PLOT",
            "PLOTDOC",
            "PLPROJ",
            "PMF",
            "PMP",
            "PMV",
            "PNS",
            "PPJ",
            "PREL",
            "PRO",
            "PRO4DVD",
            "PRO5DVD",
            "PROQC",
            "PRPROJ",
            "PRTL",
            "PSB",
            "PSH",
            "PSSD",
            "PSV",
            "PVA",
            "PVR",
            "PXV",
            "PZ",
            "QSMD",
            "QSV",
            "QT",
            "QTCH",
            "QTINDEX",
            "QTL",
            "QTM",
            "QTZ",
            "R3D",
            "RAVI",
            "RCD",
            "RCPROJECT",
            "RCREC",
            "RCUT",
            "RDB",
            "REC",
            "RL2",
            "RM",
            "RMD",
            "RMD",
            "RMP",
            "RMS",
            "RMV",
            "RMVB",
            "ROQ",
            "RP",
            "RPL",
            "RSX",
            "RTS",
            "RTS",
            "RUM",
            "RV",
            "RVID",
            "RVL",
            "SAN",
            "SBK",
            "SBT",
            "SBZ",
            "SCM",
            "SCM",
            "SCN",
            "SCREENFLOW",
            "SDV",
            "SEC",
            "SEC",
            "SEDPRJ",
            "SEQ",
            "SEQ",
            "SER",
            "SFD",
            "SFERA",
            "SIV",
            "SKM",
            "SMI",
            "SMI",
            "SMIL",
            "SMK",
            "SML",
            "SMV",
            "SPL",
            "SPRYZIP",
            "SQZ",
            "SSF",
            "SSM",
            "STX",
            "SVI",
            "SWF",
            "SWI",
            "SWT",
            "TBC",
            "TDA3MT",
            "TDT",
            "TDX",
            "TGQ",
            "TGV",
            "THEATER",
            "THP",
            "TID",
            "TIVO",
            "TIX",
            "TMV",
            "TOD",
            "TP",
            "TP0",
            "TPD",
            "TPR",
            "TREC",
            "TRP",
            "TS",
            "TSP",
            "TSV",
            "TVLAYER",
            "TVRECORDING",
            "TVS",
            "TVSHOW",
            "TY",
            "TY+",
            "USF",
            "V264",
            "VBC",
            "VC1",
            "VCPF",
            "VCR",
            "VCV",
            "VDO",
            "VDR",
            "VDX",
            "VEG",
            "VEM",
            "VEP",
            "VF",
            "VFT",
            "VFW",
            "VFZ",
            "VGZ",
            "VID",
            "VIDEO",
            "VIEWLET",
            "VII",
            "VIV",
            "VIVO",
            "VIX",
            "VLAB",
            "VMD",
            "VMLF",
            "VMLT",
            "VOB",
            "VP3",
            "VP5",
            "VP6",
            "VP7",
            "VPJ",
            "VPROJ",
            "VR",
            "VRO",
            "VS4",
            "VSE",
            "VSH",
            "VSP",
            "VSR",
            "W32",
            "WCP",
            "WEBM",
            "WFSP",
            "WGI",
            "WLMP",
            "WM",
            "WMD",
            "WMMP",
            "WMV",
            "WMX",
            "WOT",
            "WP3",
            "WPL",
            "WRF",
            "WSVE",
            "WTV",
            "WVE",
            "WVM",
            "WVX",
            "WXP",
            "XEJ",
            "XEL",
            "XESC",
            "XFL",
            "XLMV",
            "XML",
            "XMV",
            "XVID",
            "Y4M",
            "YOG",
            "YUV",
            "ZEG",
            "ZM1",
            "ZM2",
            "ZM3",
            "ZMV",
            "ZOOM"
    };
}
