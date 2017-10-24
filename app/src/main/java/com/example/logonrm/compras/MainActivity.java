package com.example.logonrm.compras;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private final String NOME_DEFAULT = "Paulo";
	private final String KEY_APP_PREFERENCES = "nome";

	private EditText etNome;
	private TextView tvLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		etNome = (EditText) findViewById(R.id.etNome);

		tvLogin = (TextView) findViewById(R.id.tvLogin);

		atualizarConectado();

		//if(isConectado())
		//	iniciarApp();
	}

	private boolean isLoginValido() {
		String login = etNome.getText().toString();

		return login.equals(NOME_DEFAULT);
	}

	private void manterConectado(){
		String login = etNome.getText().toString();
		SharedPreferences pref = getSharedPreferences(KEY_APP_PREFERENCES,
				MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString(KEY_APP_PREFERENCES, login);
		editor.apply();
	}

	private void atualizarConectado() {
		SharedPreferences shared = getSharedPreferences(KEY_APP_PREFERENCES, MODE_PRIVATE);
		String login = shared.getString(KEY_APP_PREFERENCES, "");

		tvLogin.setText(login);
	}

	private boolean isConectado() {
		SharedPreferences shared = getSharedPreferences(KEY_APP_PREFERENCES, MODE_PRIVATE);
		String login = shared.getString(KEY_APP_PREFERENCES, "");

		return !login.equals("");
	}

	private void iniciarApp() {
		startActivity(new Intent(this, ListaActivity.class));
		finish();
	}

	public void entrar(View view) {
		if (etNome.getText().toString().equals(""))
		{
			Toast.makeText(this, "Digite seu nome", Toast.LENGTH_SHORT).show();
			return;
		}

		if(isLoginValido()){
			manterConectado();

			iniciarApp();
		}
	}
}
