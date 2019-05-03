package com.projetos.appbov;

public class Login {
    private final String usuario = "admin@login.com";
    private final String senha = "admin";

    public boolean logar(String usuario, String senha) {
        if (usuario.equals(this.usuario) && senha.equals(this.senha)) {
            return true;
        }
        return false;
    }
}
