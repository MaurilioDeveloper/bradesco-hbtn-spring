package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoService produtoService;

    @Test
    void deveRetornarProdutoQuandoIdExistir() {
        // Arrange
        Long id = 1L;
        Produto produtoMock = new Produto(id, "Produto Teste", 99.9);
        Mockito.when(produtoRepository.findById(id))
                .thenReturn(Optional.of(produtoMock));

        // Act
        Produto resultado = produtoService.buscarPorId(id);

        // Assert
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals("Produto Teste", resultado.getNome());
        assertEquals(99.9, resultado.getPreco());
        Mockito.verify(produtoRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void deveLancarExcecaoQuandoProdutoNaoExistir() {
        // Arrange
        Long idInexistente = 99L;
        Mockito.when(produtoRepository.findById(idInexistente))
                .thenReturn(Optional.empty());

        // Act + Assert
        RuntimeException ex = assertThrows(
                RuntimeException.class,
                () -> produtoService.buscarPorId(idInexistente)
        );

        assertEquals("Produto não encontrado", ex.getMessage());
        Mockito.verify(produtoRepository, Mockito.times(1)).findById(idInexistente);
    }
}
