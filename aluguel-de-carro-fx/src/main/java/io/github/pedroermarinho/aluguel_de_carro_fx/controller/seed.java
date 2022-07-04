package io.github.pedroermarinho.aluguel_de_carro_fx.controller;

import io.github.pedroermarinho.aluguel_de_carro_fx.domain.entities.*;
import io.github.pedroermarinho.aluguel_de_carro_fx.domain.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class seed implements CommandLineRunner {

    private final CorRepository corRepository;
    private final FabricanteRepository fabricanteRepository;
    private final ZonaRepository zonaRepository;
    private final BairroRepository bairroRepository;
    private final AtendenteRepository atendenteRepository;
    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;
    private final AluguelRepository aluguelRepository;
    private final ModeloRepository modeloRepository;
    private final EnderecoRepository enderecoRepository;

    public seed(CorRepository corRepository, FabricanteRepository fabricanteRepository, ZonaRepository zonaRepository, BairroRepository bairroRepository, AtendenteRepository atendenteRepository, ClienteRepository clienteRepository, CarroRepository carroRepository, AluguelRepository aluguelRepository, ModeloRepository modeloRepository, EnderecoRepository enderecoRepository) {
        this.corRepository = corRepository;
        this.fabricanteRepository = fabricanteRepository;
        this.zonaRepository = zonaRepository;
        this.bairroRepository = bairroRepository;
        this.atendenteRepository = atendenteRepository;
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
        this.aluguelRepository = aluguelRepository;
        this.modeloRepository = modeloRepository;
        this.enderecoRepository = enderecoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        final var preto =corRepository.save(new CorEntity("Preto"));
        final var branco =corRepository.save(new CorEntity("Branco"));
        final var azul =corRepository.save(new CorEntity("Azul"));
        final var vermelho =corRepository.save(new CorEntity("Vermelho"));
        final var verde =corRepository.save(new CorEntity("Verde"));

        final var  zonaNorte = zonaRepository.save(new ZonaEntity("Zona Norte"));
        final var  zonaSul = zonaRepository.save(new ZonaEntity("Zona Sul"));
        final var  zonaLeste = zonaRepository.save(new ZonaEntity("Zona Leste"));
        final var  zonaOeste = zonaRepository.save(new ZonaEntity("Zona Oeste"));

        final var bairroZonaNorte =bairroRepository.save(new BairroEntity("Bairro zona norte", zonaNorte));
        final var bairroZonaSul =bairroRepository.save(new BairroEntity("Bairro zona sul", zonaSul));
        final var bairroZonaLeste =bairroRepository.save(new BairroEntity("Bairro zona leste", zonaLeste));
        final var bairroZonaOeste =bairroRepository.save(new BairroEntity("Bairro zona oeste", zonaOeste));

        final var fabricante1 = fabricanteRepository.save(new FabricanteEntity( "12345678901234","Fabricante 1"));
        final var fabricante2 = fabricanteRepository.save(new FabricanteEntity( "12345678901235","Fabricante 2"));
        final var fabricante3 = fabricanteRepository.save(new FabricanteEntity( "12345678901236","Fabricante 3"));
        final var fabricante4 = fabricanteRepository.save(new FabricanteEntity( "12345678901237","Fabricante 4"));
        final var fabricante5 = fabricanteRepository.save(new FabricanteEntity( "12345678901238","Fabricante 5"));

        final var atendente1 = atendenteRepository.save(new AtendenteEntity("atendente 1","atendente1","123" ));
        final var atendente2 = atendenteRepository.save(new AtendenteEntity("atendente 2","atendente2","123" ));
        final var atendente3 = atendenteRepository.save(new AtendenteEntity("atendente 3","atendente3","123" ));

        final var modelo1 = modeloRepository.save(new ModeloEntity("modelo 1",fabricante1));
        final var modelo2 = modeloRepository.save(new ModeloEntity("modelo 2",fabricante2));
        final var modelo3 = modeloRepository.save(new ModeloEntity("modelo 3",fabricante3));
        final var modelo4 = modeloRepository.save(new ModeloEntity("modelo 4",fabricante4));
        final var modelo5 = modeloRepository.save(new ModeloEntity("modelo 5",fabricante5));

        final var carro1 = carroRepository.save(new CarroEntity(branco,modelo1));
        final var carro2 = carroRepository.save(new CarroEntity(preto,modelo2));
        final var carro3 = carroRepository.save(new CarroEntity(azul,modelo3));
        final var carro4 = carroRepository.save(new CarroEntity(vermelho,modelo4));
        final var carro5 = carroRepository.save(new CarroEntity(verde,modelo5));

        //register enderco campos bairro
        final var endereco1 = enderecoRepository.save(new EnderecoEntity(bairroZonaNorte));
        final var endereco2 = enderecoRepository.save(new EnderecoEntity(bairroZonaSul));
        final var endereco3 = enderecoRepository.save(new EnderecoEntity(bairroZonaLeste));
        final var endereco4 = enderecoRepository.save(new EnderecoEntity(bairroZonaOeste));



        //register cliente nome, cnh, endereco
        final var cliente1 = clienteRepository.save(new ClienteEntity("cliente 1","12345678901",endereco1));
        final var cliente2 = clienteRepository.save(new ClienteEntity("cliente 2","12345678902",endereco2));
        final var cliente3 = clienteRepository.save(new ClienteEntity("cliente 3","12345678903",endereco3));
        final var cliente4 = clienteRepository.save(new ClienteEntity("cliente 4","12345678904",endereco4));


        //register aluguel campos Double valor, Integer dias, Boolean status, LocalDate devolucao, LocalDate entrega, CarroEntity carro, ClienteEntity cliente, AtendenteEntity atendente
        final var aluguel1 = aluguelRepository.save(new AluguelEntity(100.0,10,false, LocalDate.now(),LocalDate.now().plusDays(10),carro1,cliente1,atendente1));
        final var aluguel2 = aluguelRepository.save(new AluguelEntity(200.0,20,true, LocalDate.now(),LocalDate.now().plusDays(20),carro2,cliente2,atendente2));
        final var aluguel3 = aluguelRepository.save(new AluguelEntity(300.0,30,false, LocalDate.now(),LocalDate.now().plusDays(30),carro3,cliente3,atendente3));


    }
}
