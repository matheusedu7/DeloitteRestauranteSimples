package com.deloitte.bootcamp.matheus.restaurantesimples.pedido;

import com.deloitte.bootcamp.matheus.restaurantesimples.cliente.Cliente;
import com.deloitte.bootcamp.matheus.restaurantesimples.cliente.ClienteRepository;
import com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido.ItemPedido;
import com.deloitte.bootcamp.matheus.restaurantesimples.itemPedido.ItemPedidoDTO;
import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.Pedido;
import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.PedidoDTO;
import com.deloitte.bootcamp.matheus.restaurantesimples.pedido.PedidoRepository;
import com.deloitte.bootcamp.matheus.restaurantesimples.produto.Produto;
import com.deloitte.bootcamp.matheus.restaurantesimples.produto.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Pedido criarPedido(PedidoDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        List<ItemPedido> itens = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (ItemPedidoDTO itemDTO : dto.getItens()) {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPedido(pedido);

            BigDecimal subtotal = produto.getPreco().multiply(BigDecimal.valueOf(item.getQuantidade()));
            total = total.add(subtotal);

            item.setPrecoUnitario(produto.getPreco());
            itens.add(item);
        }

        if (total.compareTo(BigDecimal.valueOf(20)) < 0) {
            throw new RuntimeException("Pedido deve ter valor mínimo de R$ 20,00");
        }

        pedido.setItens(itens);
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
    }
}
