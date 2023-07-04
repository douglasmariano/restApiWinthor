package com.ajel.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajel.controller.payloads.LoginPayload;
import com.ajel.controller.payloads.PedidoPayload;
import com.ajel.controller.payloads.UsuarioPayload;
import com.ajel.jwt.JwtTokenProvider;
import com.ajel.jwt.Role;
import com.ajel.jwt.UserPrincipal;
import com.ajel.repository.filter.TabPedidosFilter;

@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private String getUsuarioQueryBySenha() {
        return "select DISTINCT matricula, nome, nome_guerra,  email, codsetor " +
                "from pcempr where NOME_GUERRA = :usuario AND decrypt(senhabd, NOME_GUERRA) = :senha";
    }

    private String getUsuarioQueryById() {
        return "select DISTINCT matricula, nome, nome_guerra,  email,codsetor " +
                "from pcempr where matricula = :matricula ";
    }
    
    private String getUsuarioQueryByNomeGuerra() {
        return "select matricula from pcempr where  nome_guerra =  :nome_guerra ";
    }
    
    private String getRolesQueryByUsuario() {
        return "SELECT AREAATUACAO_COMPRA,AREAATUACAO_VENDAS,AREAATUACAO_FINANCEIRO,AREAATUACAO_LOGISTICA,AREAATUACAO_EXPEDICAO,"
                + "AREAATUACAO_RH,AREAATUACAO_FISCAL,AREAATUACAO_CONTABIL,AREAATUACAO_OUTROS ,TIPOCARGO FROM PCEMPR where NOME_GUERRA = :usuario ";
    }

    public Object[] getMatriculaUsuario(LoginPayload loginPayload) {
        try {
            Query nativeQuery = entityManager.createNativeQuery(getUsuarioQueryBySenha());
            nativeQuery.setParameter("usuario", loginPayload.getUsuario());
            nativeQuery.setParameter("senha", loginPayload.getSenha());

            Object[] result = (Object[]) nativeQuery.getSingleResult();

            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    public String getToken(LoginPayload loginPayload) {
        Object[] usuarioPC = getMatriculaUsuario(loginPayload);
        if (usuarioPC != null) {
            BigDecimal matricula = (BigDecimal) usuarioPC[0];
            UsuarioPayload usuario = new UsuarioPayload(matricula.longValue(), (String) usuarioPC[1], (String) usuarioPC[2], (String) usuarioPC[3],(BigDecimal) usuarioPC[4], true);
            return jwtTokenProvider.generateToken(usuario);
        }
        throw new IllegalArgumentException("Usuário ou senha incorretos");
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserById(Long id) {
        try {
            Query nativeQuery = entityManager.createNativeQuery(getUsuarioQueryById());
            nativeQuery.setParameter("matricula", id);

            Object[] usuarioPC = (Object[]) nativeQuery.getSingleResult();

            if (usuarioPC != null) {
                BigDecimal matricula = (BigDecimal) usuarioPC[0];
                ;
                UserPrincipal usuario = new UserPrincipal(matricula.longValue(), (String) usuarioPC[1], (String) usuarioPC[2], (String) usuarioPC[3], (BigDecimal) usuarioPC[4], null, Arrays.asList(Role.values()));                
                return usuario;
                
            }
        } catch (NoResultException e) {
            return null;
        }
        return null;
    }
    
    public Long getUserIdByMatricula(String nomeGuerra ) {
        Query nativeQuery = entityManager.createNativeQuery(getUsuarioQueryByNomeGuerra());
        nativeQuery.setParameter("nome_guerra", nomeGuerra);
        
        BigDecimal matricula = (BigDecimal)nativeQuery.getSingleResult();
        
        return  matricula == null ? null : matricula.longValue();
    }
    
    public List<String> listRolesByUsuario(String Usuario){
        Query nativeQuery = entityManager.createNativeQuery(getRolesQueryByUsuario());
        nativeQuery.setParameter("usuario", Usuario);
        List<String> roles = new ArrayList<>();
        Object[] usuarioPC = (Object[]) nativeQuery.getSingleResult();
        if ("S".equals(usuarioPC [0])){
            roles.add("ROLE_COMPRAS");
          }
        if ("S".equals(usuarioPC [1])){
            roles.add("ROLE_VENDAS");
          }
        if ("S".equals(usuarioPC [2])){
            roles.add("ROLE_FINANCEIRO");
          }
        if ("S".equals(usuarioPC [3])){
            roles.add("ROLE_LOGISTICA");
          }
        if ("S".equals(usuarioPC [4])){
            roles.add("ROLE_EXPEDICAO");
          }
        if ("S".equals(usuarioPC [5])){
            roles.add("ROLE_RH");
          }
        if ("S".equals(usuarioPC [6])){
            roles.add("ROLE_FISCAL");
          }
        if ("S".equals(usuarioPC [7])){
            roles.add("ROLE_CONTABIL");
          }
        if ("S".equals(usuarioPC [8])){
            roles.add("ROLE_OUTROS");
          }
        if ("D".equals(usuarioPC [9])){
            roles.add("ROLE_DIRETOR");
          } else 
        if ("G".equals(usuarioPC [9])){
            roles.add("ROLE_GERENTE");
          } else
        if ("C".equals(usuarioPC [9])){
            roles.add("ROLE_COORDENADOR");
          } else
        if ("P".equals(usuarioPC [9])){
            roles.add("ROLE_OPERADOR");
          } else
        if ("T".equals(usuarioPC [9])){
            roles.add("ROLE_TI");
          } else
        if ("O".equals(usuarioPC [9])){
            roles.add("ROLE_OUTROTIPOCARGO");
          }
        return roles;
              
    }
}
