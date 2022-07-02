package com.github.tvbox.osc.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class AbsSortJson implements Serializable {

    @SerializedName(value = "class")
    public ArrayList<AbsJsonClass> classes;

    @SerializedName(value = "list")
    public ArrayList<AbsJson.AbsJsonVod> list;

    public AbsSortXml toAbsSortXml() {
        AbsSortXml absSortXml = new AbsSortXml();
        MovieSort movieSort = new MovieSort();
        movieSort.sortList = new ArrayList<>();
        for (AbsJsonClass cls : classes) {
            MovieSort.SortData sortData = new MovieSort.SortData();
            sortData.id = cls.type_id;
            sortData.name = cls.type_name;
            movieSort.sortList.add(sortData);
        }
        if (list != null && !list.isEmpty()) {
            Movie movie = new Movie();
            ArrayList<Movie.Video> videos = new ArrayList<>();
            for (AbsJson.AbsJsonVod vod : list) {
                videos.add(vod.toXmlVideo());
            }
            movie.videoList = videos;
            absSortXml.list = movie;
        } else {
            absSortXml.list = null;
        }
        absSortXml.classes = movieSort;
        return absSortXml;
    }

    public AbsSortXml toAbsSortXml(List<String> categories) {
        if(categories==null||categories.size()==0){
            return toAbsSortXml();
        }

        AbsSortXml absSortXml = new AbsSortXml();
        MovieSort movieSort = new MovieSort();
        movieSort.sortList = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        for (AbsJsonClass cls : classList) {
            map.put(cls.type_name, cls.type_id);

            if(cls.type_name.contains(" ")){
                map.put(cls.type_name.replace(" ", ""), cls.type_id);
            }
        }

        for(String category : categories){
            if(map.containsKey(category)){
                MovieSort.SortData sortData = new MovieSort.SortData();
                sortData.id = map.get(category);
                sortData.name = category;
                movieSort.sortList.add(sortData);
            }
        }

        absSortXml.movieSort = movieSort;
        return absSortXml;
    }

    public class AbsJsonClass implements Serializable {
        public String type_id;
        public String type_name;
    }

}
