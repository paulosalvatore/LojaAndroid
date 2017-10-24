package com.example.logonrm.compras.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.logonrm.compras.model.Produto;

import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {
	private DBOpenHelper banco;

	public ProdutoDAO(Context context) {
		banco = new DBOpenHelper(context);
	}

	public static final String TABELA_PRODUTOS = "produtos";
	public static final String COLUNA_ID = "id";
	public static final String COLUNA_NOME = "nome";

	public List<Produto> getAll() {
		List<Produto> produtos = new LinkedList<>();
		String query = "SELECT  * FROM " + TABELA_PRODUTOS;
		SQLiteDatabase db = banco.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		Produto produto = null;
		if (cursor.moveToFirst()) {
			do {
				produto = new Produto(
						cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
						cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
				);
				produtos.add(produto);
			} while (cursor.moveToNext());
		}
		return produtos;
	}

	public Produto getBy(int id) {
		SQLiteDatabase db = banco.getReadableDatabase();
		String colunas[] = {COLUNA_ID, COLUNA_NOME};
		String where = "id = " + id;
		Cursor cursor = db.query(true, TABELA_PRODUTOS, colunas, where, null, null,
				null, null, null);
		Produto produto = null;
		if (cursor != null) {
			cursor.moveToFirst();
			produto = new Produto(
					cursor.getInt(cursor.getColumnIndex(COLUNA_ID)),
					cursor.getString(cursor.getColumnIndex(COLUNA_NOME))
			);
		}

		return produto;
	}

	public String add(Produto produto) {
		long resultado;
		SQLiteDatabase db = banco.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COLUNA_NOME, produto.getNome());
		resultado = db.insert(TABELA_PRODUTOS,
				null,
				values);
		db.close();
		if (resultado == -1) {
			return "Erro ao inserir registro";
		} else {
			return "Registro inserido com sucesso";
		}
	}
}
