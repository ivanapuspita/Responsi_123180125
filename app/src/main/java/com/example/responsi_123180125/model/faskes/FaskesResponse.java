package com.example.responsi_123180125.model.faskes;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FaskesResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<DataItem> data){
		this.data = data;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"FaskesResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}