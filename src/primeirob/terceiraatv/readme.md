# Chat em Java💬

**WebSockets** são uma tecnologia de comunicação bidirecional que permite a troca contínua de dados entre o cliente (geralmente um navegador web) e o servidor, sem a necessidade de reabertura de conexões repetidamente, como acontece com o protocolo HTTP tradicional.

Ao contrário do HTTP, que é baseado em requisições-respostas onde o cliente sempre inicia a comunicação, o WebSocket permite uma conexão persistente onde tanto o cliente quanto o servidor podem enviar mensagens a qualquer momento.

---

### Como o WebSocket funciona

1. **Estabelecimento da conexão**: 
   - A comunicação via WebSocket começa com um **handshake** HTTP. O cliente solicita a conexão WebSocket ao servidor enviando uma requisição HTTP especial que contém um cabeçalho `Upgrade` solicitando a mudança para o protocolo WebSocket. Se o servidor aceitar, ele responde com um código de status 101, indicando que a conexão foi trocada para o protocolo WebSocket.
   
2. **Conexão aberta e persistente**:
   - Após o handshake, a conexão é estabelecida. Diferente do HTTP, que fecha a conexão após cada resposta, a conexão WebSocket permanece aberta, permitindo comunicação contínua em ambas as direções (full-duplex). Isso significa que o servidor pode enviar dados ao cliente sem esperar que o cliente faça uma solicitação, e o cliente pode enviar dados a qualquer momento.

3. **Troca de mensagens**:
   - O protocolo WebSocket permite a troca de mensagens em tempo real, sem a sobrecarga de requisições HTTP. As mensagens são enviadas em pequenos pacotes de dados binários ou texto (geralmente em formato JSON no caso de mensagens de texto). A comunicação é eficiente, com menor overhead de cabeçalhos e menor latência.
   
4. **Encerramento da conexão**:
   - A conexão pode ser fechada por qualquer uma das partes (cliente ou servidor) a qualquer momento. O fechamento é sinalizado por um código de fechamento especial que informa o motivo do término da conexão.

---

### Casos de uso

- **Aplicações de chat**: Comunicação em tempo real entre clientes e servidores.
- **Jogos multiplayer**: Sincronização rápida entre os movimentos dos jogadores. [Para mais sobre](https://dev.to/sauravmh/building-a-multiplayer-game-using-websockets-1n63).
- **Dashboards**: Atualização em tempo real de métricas e dados financeiros.

---

### Pontos de atenção

O uso de **WebSockets** traz várias vantagens, mas também apresenta **trade-offs** que devem ser considerados ao decidir utilizá-los em uma aplicação. Abaixo estão alguns dos principais pontos a favor e contra o uso dessa tecnologia:

### Vantagens
1. **Comunicação em tempo real**:
   - WebSockets permitem comunicação bidirecional em tempo real, essencial para aplicações como chats, jogos multiplayer, e monitoramento de dados em tempo real.

2. **Baixa latência**:
   - Por não haver necessidade de estabelecer uma nova conexão a cada requisição (como no HTTP), WebSockets minimizam a latência, sendo ideais para casos onde o tempo de resposta é crítico.

3. **Eficiência de largura de banda**:
   - Após o handshake inicial via HTTP, a comunicação WebSocket é mais eficiente, com menos overhead por mensagem, pois não há repetição de cabeçalhos longos em cada transmissão, como no HTTP tradicional.

4. **Bidirecionalidade**:
   - Tanto o cliente quanto o servidor podem iniciar o envio de dados, o que melhora a eficiência de cenários onde é necessário que o servidor envie dados para o cliente de forma assíncrona (como em sistemas de notificação ou alertas).

### Trade-offs

1. **Persistência da conexão**:
   - WebSockets mantêm a conexão aberta entre o cliente e o servidor, o que pode aumentar o consumo de recursos no servidor. Para aplicações com muitos usuários simultâneos, é necessário garantir que o servidor consiga lidar com um grande número de conexões simultâneas de forma eficiente, o que pode exigir mais memória e processamento.

2. **Escalabilidade**:
   - Comparado ao HTTP, que é naturalmente stateless (sem estado), o WebSocket requer que o servidor mantenha o estado da conexão. Isso pode complicar a escalabilidade da aplicação. Em arquiteturas distribuídas ou balanceadas, garantir que todas as instâncias de servidor possam gerenciar adequadamente essas conexões persistentes pode ser desafiador.
   - Soluções como **sticky sessions** (sessões fixas) ou o uso de servidores especializados em comunicação em tempo real (como **Redis** para comunicação entre instâncias) podem ser necessárias, mas aumentam a complexidade da infraestrutura.

3. **Compatibilidade com proxies e firewalls**:
   - Nem todos os proxies HTTP ou firewalls são compatíveis com WebSockets. Alguns podem bloquear ou interromper a comunicação WebSocket, já que ela utiliza a porta 80/443, mas opera de maneira diferente do HTTP tradicional. Isso pode exigir configurações especiais em redes corporativas, por exemplo.

4. **Manutenção de conexão em redes instáveis**:
   - Em ambientes com redes instáveis ou com conexões móveis (como 4G ou 5G), manter uma conexão WebSocket aberta pode ser problemático, pois a conexão pode cair e precisar ser reestabelecida. Para contornar isso, é necessário implementar lógica adicional no cliente para reconectar automaticamente e gerenciar falhas de conexão.

5. **Segurança**:
   - Embora WebSockets possam utilizar criptografia (via **wss://**, que é o equivalente ao **https://**), a própria natureza da comunicação bidirecional contínua pode aumentar a superfície de ataque, especialmente se não houver controle adequado sobre quem pode se conectar ou quais dados podem ser enviados.
   - WebSockets não seguem o modelo tradicional de requisição-resposta, onde o servidor pode verificar a autorização para cada requisição. Isso requer uma implementação de segurança robusta, como **tokens de autenticação** (JWT) ou mecanismos de controle de acesso.

6. **Complexidade adicional no lado do servidor**:
   - Ao contrário do HTTP, que é fácil de escalar usando servidores web tradicionais, o WebSocket pode requerer servidores especializados que lidam com conexões persistentes de maneira eficiente. Servidores baseados em threads podem ter problemas com escalabilidade, então tecnologias como **event-driven architectures** (baseadas em eventos) podem ser mais adequadas (por exemplo, **Node.js**, **Vert.x** ou **Netty**).

7. **Fallbacks necessários**:
   - Em ambientes onde WebSockets não são suportados (por exemplo, navegadores mais antigos ou redes restritivas), é importante implementar **fallbacks** (soluções alternativas), como **long-polling** ou **Server-Sent Events (SSE)**. Isso pode adicionar complexidade ao código da aplicação.

---

### Comparação com alternativas

- **Long polling**: Embora seja uma técnica amplamente usada para emular comunicação em tempo real, ele causa mais overhead, pois mantém fazendo requisições HTTP repetidas ao servidor. Isso pode ser menos eficiente que WebSockets, mas evita alguns dos problemas de compatibilidade com proxies e firewalls.
  
- **Server-Sent Events (SSE)**: Uma tecnologia unidirecional onde o servidor pode enviar atualizações ao cliente. É mais simples de implementar e escalável do que WebSockets, mas não permite comunicação bidirecional, sendo limitado a casos onde apenas o servidor precisa enviar dados.

---

### Quando NÃO usar WebSockets

1. **Aplicações com Baixa Frequência de Atualizações**:
   - Se a aplicação não requer atualizações constantes em tempo real, o uso de WebSockets pode ser um exagero. Um modelo tradicional de requisição HTTP pode ser mais simples e eficiente.

2. **Recursos Limitados no Servidor**:
   - Em aplicações de larga escala, onde o servidor precisa lidar com um número muito grande de usuários ao mesmo tempo, manter conexões WebSocket pode consumir muitos recursos e gerar complicações de escalabilidade.

---

### Exemplo de Server com WebSocket em Java

Abaixo um exemplo de uma classe que inicia um server:

```java
class Server {
    private ServerSocket server;
    private Socket socket;

    private BufferedReader reader;
    private PrintWriter writer;

    public static void main(String[] args) {
        System.out.println("Iniciando servidor do chat...");

        new Server();
    }

    public Server() {
        try {
            server = new ServerSocket(7777);
            System.out.println("Servidor está pronto para receber conexões✅");
            System.out.println("Aguardando...");
            socket = server.accept();

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            writer = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        } catch (Exception ex) {
            System.out.println("Erro ao iniciar servidor do chat..." + ex.getMessage());
        }
    }

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Iniciando leitura...");

            try {
                while (true) {

                    String msg = reader.readLine();
                    if (msg.equals("EXIT")) {
                        System.out.println("Client terminou o chat!!");
                        socket.close();

                        break;
                    }

                    System.out.println("Client : " + msg);

                }
            } catch (Exception e) {
                System.out.print("----Conexão finalizada----");
            }
        };

        new Thread(r1).start();
    }

    public void startWriting() {
        Runnable r2 = () -> {
            System.out.println("Iniciando escrita...");

            try {
                while (!socket.isClosed()) {

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

                    String content = br1.readLine();
                    writer.println(content);
                    writer.flush();

                    if (content.equals("EXIT")) {
                        socket.close();
                        break;
                    }

                    System.out.print("----Última mensagem----\n");
                }
            } catch (Exception e) {
            }
        };

        new Thread(r2).start();
    }

}
```

### Atributos da Classe:

- `ServerSocket server`: Um objeto `ServerSocket` responsável por aceitar conexões de clientes na porta 7777.
- `Socket socket`: Um objeto `Socket` que representa a conexão do cliente com o servidor após a conexão ser aceita.
- `BufferedReader reader`: Um fluxo de entrada de dados do cliente, usado para ler as mensagens enviadas pelo cliente.
- `PrintWriter writer`: Um fluxo de saída de dados do servidor, usado para enviar mensagens para o cliente.

### Método `main`

```java
public static void main(String[] args) {
    System.out.println("Iniciando servidor do chat...");
    new Server();
}
```

- O método `main` é o ponto de entrada da aplicação. Ele cria uma nova instância da classe `Server`, o que inicia o servidor de chat.
- Exibe uma mensagem inicial para informar que o servidor está sendo iniciado.

### Construtor `Server`

```java
public Server() {
    try {
        server = new ServerSocket(7777);
        System.out.println("Servidor está pronto para receber conexões✅");
        System.out.println("Aguardando...");
        socket = server.accept();

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream());

        startReading();
        startWriting();
    } catch (Exception ex) {
        System.out.println("Erro ao iniciar servidor do chat..." + ex.getMessage());
    }
}
```

- O **construtor** é chamado quando uma instância de `Server` é criada.
- **ServerSocket** é inicializado na porta 7777, que significa que o servidor está escutando conexões nessa porta.
- O método `server.accept()` bloqueia a execução até que um cliente se conecte ao servidor, após o qual o objeto `Socket` será atribuído.
- Os fluxos de entrada e saída de dados são configurados: 
  - `reader`: Leitura de mensagens do cliente.
  - `writer`: Envio de mensagens para o cliente.
- Os métodos `startReading()` e `startWriting()` são chamados para iniciar as threads que tratam da leitura e escrita de mensagens de forma simultânea.

### Método `startReading`

```java
public void startReading() {
    Runnable r1 = () -> {
        System.out.println("Iniciando leitura...");

        try {
            while (true) {
                String msg = reader.readLine();
                if (msg.equals("EXIT")) {
                    System.out.println("Client terminou o chat!!");
                    socket.close();
                    break;
                }

                System.out.println("Client : " + msg);
            }
        } catch (Exception e) {
            System.out.print("----Conexão finalizada----");
        }
    };

    new Thread(r1).start();
}
```

- O método `startReading()` cria e inicia uma nova **thread** (`Thread`) para leitura das mensagens enviadas pelo cliente.
- O loop `while (true)` garante que o servidor continue lendo as mensagens até que o cliente envie "EXIT", o que sinaliza o término da conexão.
- Se a mensagem "EXIT" for recebida, a conexão é fechada, e o loop é interrompido.
- As mensagens recebidas do cliente são exibidas no console do servidor.
- O uso de uma thread separada permite que o servidor leia as mensagens sem bloquear a execução de outras tarefas, como enviar mensagens.

### Método `startWriting`

```java
public void startWriting() {
    Runnable r2 = () -> {
        System.out.println("Iniciando escrita...");

        try {
            while (!socket.isClosed()) {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                String content = br1.readLine();
                writer.println(content);
                writer.flush();

                if (content.equals("EXIT")) {
                    socket.close();
                    break;
                }

                System.out.print("----Última mensagem----\n");
            }
        } catch (Exception e) {
        }
    };

    new Thread(r2).start();
}
```

- O método `startWriting()` também cria e inicia uma nova **thread** para enviar mensagens ao cliente.
- Um loop `while (!socket.isClosed())` verifica continuamente se o servidor pode enviar mensagens. Ele permite que o servidor escreva e envie mensagens até que o socket seja fechado.
- O servidor lê as mensagens da entrada padrão (teclado) usando `BufferedReader`, envia as mensagens para o cliente via `writer.println()`, e usa `writer.flush()` para garantir que a mensagem seja transmitida imediatamente.
- Se a mensagem "EXIT" for enviada, o servidor fecha a conexão e encerra o loop.

### Threads utilizadas

A classe utiliza duas threads separadas:
1. Uma thread para **ler** as mensagens do cliente (`startReading`).
2. Outra thread para **enviar** mensagens ao cliente (`startWriting`).

Isso permite que o servidor trate a leitura e a escrita de forma simultânea, garantindo que uma operação (como enviar uma mensagem) não bloqueie a outra (como ler uma mensagem).

### Resumo da ópera

Servidor funciona da seguinte forma:
- Inicia a aplicação na porta 7777.
- Aceita uma conexão de um cliente.
- Duas threads são criadas: uma para ler mensagens do cliente e outra para enviar mensagens ao cliente.
- O servidor continua a operar até que o cliente ou o servidor envie a mensagem "EXIT", encerrando a conexão.

---

### Resumo de websockets

WebSockets são muito úteis para cenários que exigem comunicação em tempo real e bidirecional, mas eles vêm com uma série de trade-offs, especialmente em relação a escalabilidade, consumo de recursos e compatibilidade com redes. A escolha entre WebSockets e outras tecnologias depende das necessidades específicas da aplicação e da infraestrutura disponível.

---

### Atividade📝

Crie um chat utilizando websockets e Java, realize a comunicação entre o servidor e o cliente. Aqui temos duas abordagens, com base no material, desenvolver a Classe cliente que irá se conectar ao nosso server de exemplo, ou utilizar os materiais disponíveis no notion, na aba "vídeos".