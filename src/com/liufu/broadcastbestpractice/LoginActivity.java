package com.liufu.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {

	private SharedPreferences pref;

	private SharedPreferences.Editor editor;

	private CheckBox remeberPass;

	private EditText accountEdit;

	private EditText passwordEdit;

	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		pref = PreferenceManager.getDefaultSharedPreferences(this);

		accountEdit = (EditText) findViewById(R.id.account);

		passwordEdit = (EditText) findViewById(R.id.password);

		remeberPass = (CheckBox) findViewById(R.id.remeber_pass);

		boolean isRemeber = pref.getBoolean("remeber_password", false);
		if (isRemeber) {
			String account = pref.getString("account", "");
			String password = pref.getString("password", "");
			accountEdit.setText(account);
			passwordEdit.setText(password);
			remeberPass.setChecked(true);
		}

		login = (Button) findViewById(R.id.login);
		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				String account = accountEdit.getText().toString();
				String password = passwordEdit.getText().toString();

				if (account.equals("admin") && password.equals("123456")) {
					editor = pref.edit();
					if (remeberPass.isChecked()) {

						editor.putString("account", account);
						editor.putString("password", password);
						editor.putBoolean("remeber_password", true);
						editor.commit();
					} else {
						editor.clear();
					}
					Intent intent = new Intent(LoginActivity.this,
							MainActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(LoginActivity.this,
							"Account or password is invalid",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
	}
}
