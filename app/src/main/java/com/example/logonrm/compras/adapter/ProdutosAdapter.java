package com.example.logonrm.compras.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.logonrm.compras.R;
import com.example.logonrm.compras.model.Produto;
import com.example.logonrm.compras.model.ProdutoViewHolder;

import java.util.List;

/**
 * Created by logonrm on 20/10/2017.
 */

public class ProdutosAdapter extends BaseAdapter {
	private Context context;
	private List<Produto> produtos;
	public ProdutosAdapter(Context context, List<Produto> produtos) {
		this.context = context;
		this.produtos = produtos;
	}

	@Override
	public int getCount() {
		return produtos.size();
	}

	@Override
	public Object getItem(int position) {
		return produtos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return produtos.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;

		ProdutoViewHolder holder;

		if (convertView == null) {
			view = LayoutInflater.from(context).inflate(R.layout.produto_item, parent, false);
			holder = new ProdutoViewHolder(view);
			view.setTag(holder);
		}
		else {
			view = convertView;
			holder = (ProdutoViewHolder)view.getTag();
		}

		Produto produto = produtos.get(position);

		holder.tvNome.setText(produto.getNome());

		return view;
	}
}

