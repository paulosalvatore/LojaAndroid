package com.example.logonrm.compras;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.logonrm.compras.adapter.ProdutosAdapter;
import com.example.logonrm.compras.dao.ProdutoDAO;
import com.example.logonrm.compras.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

	private static final String KEY_APP_PREFERENCES = "nome";

	private EditText etProduto;

	private TextView tvNome;

	private List<Produto> produtos = new ArrayList<>();
	private ListView lvProdutos;
	private List<Produto> listaProdutos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista);

		etProduto = (EditText) findViewById(R.id.etProduto);

		tvNome = (TextView) findViewById(R.id.tvNome);

		atualizarConectado();

		lvProdutos = (ListView) findViewById(R.id.lvProdutos);

		carregaProdutos();
	}

	private void atualizarConectado() {
		SharedPreferences shared = getSharedPreferences(KEY_APP_PREFERENCES, MODE_PRIVATE);
		String login = shared.getString(KEY_APP_PREFERENCES, "");

		tvNome.setText(login);
	}

	public void salvar(View view) {
		ProdutoDAO produtoDAO = new ProdutoDAO(this);
		Produto produto = new Produto(0, etProduto.getText().toString());
		produtos.add(produto);

		produtoDAO.add(produto);

		lvProdutos.setAdapter(new ProdutosAdapter(ListaActivity.this, produtos));
	}

	private void carregaProdutos() {
		ProdutoDAO produtoDAO = new ProdutoDAO(this);

		produtos = produtoDAO.getAll();

		lvProdutos.setAdapter(new ProdutosAdapter(ListaActivity.this, produtos));
	}

	public List<Produto> getListaProdutos() {
		produtos.add(new Produto(1, "Teste"));

		return produtos;
	}
}
