package com.example.lhries.crud_contatos_bd.dao.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDadosOpenHelper extends SQLiteOpenHelper{

	private static String nome="crudAluno.db";
	private static String create="CREATE TABLE contato" +
			"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
			"nome VARCHAR(50),"+
			"telefone VARCHAR(20))";
	
	public BancoDadosOpenHelper(Context contexto) {
		super(contexto, nome, null, 1);
	}
	
	@Override
	public void onCreate(SQLiteDatabase banco) {
		banco.execSQL(create);
	}

	@Override
	public void onUpgrade(SQLiteDatabase banco, int versaoAntiga, int versaoNova) {
		banco.execSQL("DROP TABLE contato");
		onCreate(banco);
	}
	

}
