<h1>RPG Battle API</h1>
<p>Esta é a documentação para a API Rest do RPG Battle, um jogo de batalha épica no estilo Advanced Dungeons & Dragons (AD&D). Nossa API foi desenvolvida usando Java SpringBoot com um banco de dados Postgres. O jogo é baseado em turnos, onde você pode escolher um herói ou monstro para lutar contra seu oponente. Prepare-se para lançar dados, calcular ataques, defender-se e gerenciar seus pontos de vida!</p>
<h2>Funcionalidades</h2>
<h3>1. Escolha do Personagem</h3>
<ul>
    <li>Ao iniciar o jogo, você precisa escolher um personagem, que pode ser um herói ou monstro.</li>
    <li>Cada personagem possui atributos únicos, incluindo Pontos de Vida (PV).</li>
    <li>Se os PV de um personagem chegar a zero ou menos, o oponente será declarado vencedor.</li>
</ul>
<h3>2. Atributos dos Personagens</h3>
<h4>Heróis pré-inseridos</h4>
<table>
    <tr>
        <th>Personagem</th>
        <th>Vida</th>
        <th>Força</th>
        <th>Defesa</th>
        <th>Agilidade</th>
        <th>Quantidade de Dados</th>
        <th>Faces do Dado</th>
    </tr>
    <tr>
        <td>Guerreiro</td>
        <td>20</td>
        <td>7</td>
        <td>5</td>
        <td>6</td>
        <td>1</td>
        <td>12</td>
    </tr>
    <tr>
        <td>Bárbaro</td>
        <td>21</td>
        <td>10</td>
        <td>2</td>
        <td>5</td>
        <td>2</td>
        <td>8</td>
    </tr>
    <tr>
        <td>Cavaleiro</td>
        <td>26</td>
        <td>6</td>
        <td>8</td>
        <td>3</td>
        <td>2</td>
        <td>6</td>
    </tr>
</table>
<h4>Monstros pré-inseridos</h4>
<table>
    <tr>
        <th>Personagem</th>
        <th>Vida</th>
        <th>Força</th>
        <th>Defesa</th>
        <th>Agilidade</th>
        <th>Quantidade de Dados</th>
        <th>Faces do Dado</th>
    </tr>
    <tr>
        <td>Orc</td>
        <td>42</td>
        <td>7</td>
        <td>1</td>
        <td>2</td>
        <td>3</td>
        <td>4</td>
    </tr>
    <tr>
        <td>Gigante</td>
        <td>34</td>
        <td>10</td>
        <td>4</td>
        <td>4</td>
        <td>2</td>
        <td>6</td>
    </tr>
    <tr>
        <td>Lobisomen</td>
        <td>34</td>
        <td>7</td>
        <td>4</td>
        <td>7</td>
        <td>2</td>
        <td>4</td>
    </tr>
</table>
<h3>3. Dados</h3>
<ul>
    <li>No jogo, você usará dados para calcular ataques, defesa e danos.</li>
    <li>A notação "1dX" significa lançar um dado de X faces, resultando em um número aleatório entre 1 e X.</li>
    <li>Por exemplo, "1d12" significa lançar um dado de 12 faces, resultando em um número entre 1 e 12.</li>
    <li>Para lançar múltiplos dados, use a notação "XdY". Por exemplo, "2d8" significa lançar dois dados de 8 faces e somar os resultados.</li>
</ul>
<h3>4. Fluxo do Jogo</h3>

<h4>1) Criar mesa</h4>
<ul>
    <li>A mesa é onde sera executado a partida.</li>
    <li>Pode ser criada varias mesas com varios herois e monstros.</li>
</ul>

<h4>2) Iniciativa</h4>
<ul>
    <li>A iniciativa determina quem começa o turno. Isso é feito lançando um dado de 20 faces (1d20).</li>
    <li>O jogador com o maior resultado obtém a iniciativa.</li>
</ul>
<h4>3) Turno</h4>
<p>O turno é dividido em duas partes: Ataque e Defesa.</p>
<p>Não a diferença entro turno do jogador e da maquina portanto ambos devem ser jogados iguais.</p>
<h5>3.1) Ataque</h5>
<ul>
    <li>O ataque é calculado somando o resultado de 1d12 com a Força e Agilidade do atacante.</li>
</ul>
<h5>3.2) Defesa</h5>
<ul>
    <li>A defesa é calculada somando o resultado de 1d12 com a Defesa e Agilidade do defensor.</li>
    <li>Se o ataque for maior que a defesa, o dano será calculado.</li>
</ul>
<h4>4) Dano</h4>
<ul>
    <li>O dano é calculado com base na quantidade de dados e faces do dado do personagem.</li>
    <li>Some o valor da Força do personagem ao resultado dos dados para obter o dano.</li>
    <li>Exemplo: Bárbaro → 2d8, resultando em um valor de dano entre 2 e 16.</li>
</ul>
<h4>5) Pontos de Vida</h4>
<ul>
    <li>Subtraia o valor do dano dos Pontos de Vida do personagem.</li>
    <li>O personagem com zero ou menos PV perde a luta.</li>
</ul>
<h4>6) Fim do Turno</h4>
<ul>
    <li>Se nenhum personagem tiver zero ou menos PV no final do turno, o jogo continua com o próximo turno.</li>
</ul>
<h3>5) Histórico</h3>
<ul>
    <li>Todos os detalhes das batalhas são registrados em uma tabela de LOG para futura conferência.</li>
    <li>Isso inclui informações sobre os heróis, monstros, quem iniciou a batalha e os resultados de cada turno.</li>
</ul>
<h3>6) Endpoints</h3>
<p>Você é livre para criar os endpoints, mas esperamos pelo menos os seguintes:</p>
<ul>
    <li>POST<code>/character/</code>: Realiza a criação de um novo Heroi/Monstro.</li>
    <li>GET<code>/character/{characterId}</code>: Coleta uma lista de todos os Herois/Monstros.</li>
    <li>PUT<code>/character/{characterId}</code>: Atualiza Um Heroi/Monstro.</li>
    <li>DELETE<code>/character/{characterId}</code>: Deleta Um Heroi/Monstro.</li>
    <li>POST<code>/table/</code>: Realiza a criação de uma nova Mesa de jogo.</li>
    <li>GET<code>/table/{tableId}</code>: Coleta uma lista de todas as mesas de jogo.</li>
    <li>PUT<code>/table/{tableId}</code>: Realiza a jogada de iniciativa para saber quem começa a atacar na mesa.</li>
    <li>DELETE<code>/table/{tableId}</code>: Deleta Uma mesa </li>
    <li>PUT<code>/round/{tableId}</code>: Realiza um ataque.</li>
    <li>POST<code>/round/{tableId}</code>: Realiza uma ação de defesa.</li>
    <li>PUT<code>/round/damage/{tableId}</code>: Calcula o dano de um ataque.</li>
</ul>

<h2>Como Executar o Projeto</h2>

<p>Para executar o projeto RPG Battle API localmente, siga as instruções abaixo. Certifique-se de ter o PostgreSQL instalado e configurado em sua máquina.</p>

<h3>Configuração do Banco de Dados</h3>

<p>Antes de executar o projeto, é necessário configurar o banco de dados PostgreSQL com as seguintes informações:</p>

<pre>
  <code>
    environment:
      POSTGRES_PASSWORD: Eraumavez
      POSTGRES_USER: desafio
      POSTGRES_DB: Ad&d
    ports:
      - '5433:5432'
  </code>
</pre>

<h3>Configuração da Porta</h3>

<p>O projeto está configurado para ser executado na porta 9080. Certifique-se de que esta porta esteja disponível ou ajuste a configuração, se necessário.</p>

<pre>
  <code>
  port: 9080
  </code>
</pre>

<h3>Executando o Projeto com Gradle</h3>

<p>Para executar o projeto utilizando o sistema de build Gradle, siga estas etapas:</p>

<ol>
  <li>Clone o repositório do projeto para o seu computador.</li>
  <li>Abra um terminal na pasta raiz do projeto.</li>
  <li>Execute o seguinte comando para construir e iniciar o projeto:</li>
</ol>

<pre>
  <code>
  ./gradlew bootRun
  </code>
</pre>

<p>O SpringBoot iniciará o servidor na porta especificada (9080 por padrão).</p>

<h3>Acessando a Documentação com Swagger</h3>

<p>A documentação da API está disponível através do Swagger UI. Para acessá-la, siga estas etapas:</p>

<ol>
  <li>Abra um navegador da web.</li>
  <li>Acesse o seguinte URL: <a href="http://localhost:9080/swagger-ui.html" target="_blank">http://localhost:9080/swagger-ui.html</a></li>
</ol>

<p>Você verá a interface do Swagger UI, que permitirá explorar e testar os endpoints da API.</p>

<p>Agora você está pronto para interagir com a API RPG Battle e desfrutar do jogo!</p>

<h2>Contribuições</h2>
<ul>
    <li>Sinta-se à vontade para contribuir para este projeto. ficarei felizes em receber suas sugestões e melhorias.</li>
</ul>
<h2>Contato</h2>
<ul>
    <li>Para dúvidas ou sugestões, entre em contato conosco pelo email: <a href="mailto:d-asantana@live.com">d-asantana@live.com</a>.</li>
</ul>
<p>Divirta-se jogando e desenvolvendo a API do RPG Battle!</p>
