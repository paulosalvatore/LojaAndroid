package com.example.logonrm.compras.model;

import android.view.View;
import android.widget.TextView;

import com.example.logonrm.compras.R;

/**
 * Created by logonrm on 20/10/2017.
 */

public class ProdutoViewHolder {
	public final TextView tvNome;

	public ProdutoViewHolder(View view) {
		tvNome = (TextView)view.findViewById(R.id.tvNome);
	}
}