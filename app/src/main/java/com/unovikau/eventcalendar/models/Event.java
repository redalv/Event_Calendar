package com.unovikau.eventcalendar.models;

import android.util.Log;

import com.google.firebase.database.IgnoreExtraProperties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@IgnoreExtraProperties
public class Event {

    private String id;
    private String name;
    private String article;
    private String address;
    private String time;
    private String timeEnd;
    private Date date;
    private Date dateEnd;
    private Boolean isImportant;
    private Double lat;
    private Double lng;
    private Long type;
    private Long subtype;
    private List<String> images;

    public Event() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Event(String name, String article, String address, String time, String timeEnd, String date, String dateEnd,
                 Boolean isImportant, Double lat, Double lng, Long type, Long subtype, List<String> images) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try{
            this.date = sdf.parse(date);
        }
        catch (ParseException e){
            Log.e("date", e.getMessage());
        }

        if(dateEnd!=null && !dateEnd.equals("")){
            try{
                this.dateEnd = sdf.parse(dateEnd);
            }
            catch (ParseException e){
                Log.e("dateEnd", e.getMessage());
            }
        }

        this.name = name;
        this.article = article;
        this.address = address;
        this.isImportant = isImportant;
        this.time = time;
        this.timeEnd = timeEnd;
        this.lat = lat;
        this.lng = lng;
        this.type = type;
        this.subtype = subtype;
        this.images = images;
    }

    @Override
    public String toString(){
       return name;
    }

    public String getId() {  return id;  }
    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try{
            this.date = sdf.parse(date);
        }
        catch (ParseException e){
            Log.e("date", e.getMessage());
        }
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try{
            this.dateEnd = sdf.parse(dateEnd);
        }
        catch (ParseException e){
            Log.e("date", e.getMessage());
        }
    }

    public Long getSubtype() {
        return subtype;
    }

    public void setSubtype(Long subtype) {
        this.subtype = subtype;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(this.date.getTime());
    }

    public String getDateEndString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return simpleDateFormat.format(this.dateEnd.getTime());
    }

    public boolean isPastEvent(){
        boolean result = false;

        Date today = new Date();
        if(this.dateEnd == null){
            result = this.date.before(today);
        }
        else{
            result =  this.date.before(today) && this.dateEnd.before(today);
        }

        return result;
    }
}