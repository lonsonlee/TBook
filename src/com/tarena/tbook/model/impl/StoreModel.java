package com.tarena.tbook.model.impl;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tarena.tbook.MyApplication;
import com.tarena.tbook.entity.Book;
import com.tarena.tbook.model.IStoreModel;
import com.tarena.tbook.util.GlobalConsts;
import com.tarena.tbook.util.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Created by hanamingming on 16/2/23.
 */
public class StoreModel implements IStoreModel {
	private RequestQueue queue;

	public StoreModel() {
		queue = Volley.newRequestQueue(MyApplication.getContext());
	}

	@Override
	public void getRecommendList(final AsyncCallback callback) {
		String url= GlobalConsts.URL_LOAD_RECOMMEND_BOOK_LIST;
		StringRequest request=new StringRequest(StringRequest.Method.GET,url,new Response.Listener<String>() {
			public void onResponse(String response) {
				try {
					JSONObject object=new JSONObject(response);
					int code=object.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS) {
						JSONArray array = object.getJSONArray("data");
						List<Book> books = JSONParser.parseBookList(array);
						callback.onSuccess(books);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {
				Log.e("error", "response:"+error.getMessage());
			}
		});
		queue.add(request);
	}

	@Override
	public void getHotList(final AsyncCallback callback) {
		String url= GlobalConsts.URL_LOAD_HOT_BOOK_LIST;
		StringRequest request=new StringRequest(StringRequest.Method.GET,url,new Response.Listener<String>() {
			public void onResponse(String response) {
				try {
					JSONObject object=new JSONObject(response);
					int code=object.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS) {
						JSONArray array = object.getJSONArray("data");
						List<Book> books = JSONParser.parseBookList(array);
						callback.onSuccess(books);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {
				Log.e("error", "response:"+error.getMessage());
			}
		});
		queue.add(request);
	}

	@Override
	public void getNewList(final AsyncCallback callback) {
		String url= GlobalConsts.URL_LOAD_NEW_BOOK_LIST;
		StringRequest request=new StringRequest(StringRequest.Method.GET,url,new Response.Listener<String>() {
			public void onResponse(String response) {
				try {
					JSONObject object=new JSONObject(response);
					int code=object.getInt("code");
					if(code==GlobalConsts.RESPONSE_CODE_SUCCESS) {
						JSONArray array = object.getJSONArray("data");
						List<Book> books = JSONParser.parseBookList(array);
						callback.onSuccess(books);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		},new Response.ErrorListener() {
			public void onErrorResponse(VolleyError error) {
				Log.e("error", "response:"+error.getMessage());
			}
		});
		queue.add(request);
	}
}
