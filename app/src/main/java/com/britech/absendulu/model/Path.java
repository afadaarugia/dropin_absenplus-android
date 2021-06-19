package com.britech.absendulu.model;

import com.google.gson.annotations.SerializedName;

public class Path{

    @SerializedName("foto")
    private String foto;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("users_id")
    private int usersId;

    @SerializedName("id")
    private int id;

    @SerializedName("deleted_at")
    private Object deletedAt;

    public void setFoto(String foto){
        this.foto = foto;
    }

    public String getFoto(){
        return foto;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt(){
        return createdAt;
    }

    public void setUsersId(int usersId){
        this.usersId = usersId;
    }

    public int getUsersId(){
        return usersId;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setDeletedAt(Object deletedAt){
        this.deletedAt = deletedAt;
    }

    public Object getDeletedAt(){
        return deletedAt;
    }
}