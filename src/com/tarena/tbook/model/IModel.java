package com.tarena.tbook.model;

import com.android.volley.RequestQueue;

/**
 * Created by hanamingming on 16/2/23.
 */
public interface IModel {




	public interface AsyncCallback {

		void onSuccess(Object success);

		void onError(Object error);

	}

}
