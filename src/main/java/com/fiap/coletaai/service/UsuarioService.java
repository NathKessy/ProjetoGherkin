package com.fiap.coletaai.service;

import com.fiap.coletaai.dto.UsuarioCadastroDTO;
import com.fiap.coletaai.dto.UsuarioExibicaoDTO;
import com.fiap.coletaai.model.UsuarioEntity;
import com.fiap.coletaai.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDTO salvarUsuario(UsuarioCadastroDTO usuarioDTO){

        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioDTO.senha());

        UsuarioEntity usuario = new UsuarioEntity();
        BeanUtils.copyProperties(usuarioDTO, usuario);
        usuario.setSenha(senhaCriptografada);

        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDTO(usuarioSalvo);

    }

    public UsuarioExibicaoDTO listarPorId(Integer id) {
        Optional<UsuarioEntity> usuarioOptional =
                usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return new UsuarioExibicaoDTO(usuarioOptional.get());
        } else {
            throw new RuntimeException("Usuário não existe!");
        }
    }

    public List<UsuarioExibicaoDTO> listarTodos() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDTO::new)
                .toList();
    }

}
