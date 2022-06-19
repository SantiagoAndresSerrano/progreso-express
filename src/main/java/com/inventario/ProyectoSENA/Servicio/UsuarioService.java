/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.inventario.ProyectoSENA.Servicio;

import com.inventario.ProyectoSENA.Modelo.LoginUsuario;
import com.inventario.ProyectoSENA.Modelo.Usuario;
import java.util.List;

/**
 *
 * @author johnny
 */
public interface UsuarioService {
    public List<Usuario> getUsuarios();
    public void guardarUsuario(Usuario usuario);
    public boolean encontrarUsuarioCorreo(String correo);
    public boolean encontrarUsuario(int id);
    public Usuario buscarUsuario(int id);
    public Usuario loginUsuario(LoginUsuario loginUsuario);

}
