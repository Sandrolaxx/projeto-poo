## Conceitos de I/O em Java

Em Java, a entrada e saída (I/O) são gerenciadas através de um conjunto de classes e interfaces fornecidas nos pacotes `java.io` e `java.nio`. Esses pacotes permitem ler e gravar dados em diferentes fontes, como arquivos, streams de rede, dispositivos de entrada/saída, e muito mais. Vamos discutir as principais funcionalidades, classes e conceitos associados à I/O em Java.

#### Streams de I/O🔄

A base da I/O em Java é o conceito de streams, que são fluxos de dados que podem ser lidos ou escritos sequencialmente. Existem dois tipos principais de streams em Java:

1. **Byte Streams**:
   - Usados para manipular dados binários.
   - Classes principais:
     - `InputStream`: Classe base para todos os streams de entrada de bytes.
     - `OutputStream`: Classe base para todos os streams de saída de bytes.

2. **Character Streams**:
   - Usados para manipular dados de caracteres (texto).
   - Classes principais:
     - `Reader`: Classe base para todos os streams de entrada de caracteres.
     - `Writer`: Classe base para todos os streams de saída de caracteres.

#### Byte Streams

##### InputStream
- **Descrição**: Classe abstrata para ler bytes de um stream de entrada.
- **Métodos Comuns**:
  - `int read()`: Lê o próximo byte de dados.
  - `int read(byte[] b)`: Lê bytes e armazena no array fornecido.
  - `void close()`: Fecha o stream e libera recursos associados.

##### OutputStream
- **Descrição**: Classe abstrata para escrever bytes em um stream de saída.
- **Métodos Comuns**:
  - `void write(int b)`: Escreve um byte.
  - `void write(byte[] b)`: Escreve bytes de um array.
  - `void close()`: Fecha o stream e libera recursos associados.

#### Character Streams

##### Reader
- **Descrição**: Classe abstrata para ler caracteres de um stream de entrada.
- **Métodos Comuns**:
  - `int read()`: Lê um único caractere.
  - `int read(char[] cbuf)`: Lê caracteres e armazena no array fornecido.
  - `void close()`: Fecha o stream e libera recursos associados.

##### Writer
- **Descrição**: Classe abstrata para escrever caracteres em um stream de saída.
- **Métodos Comuns**:
  - `void write(int c)`: Escreve um único caractere.
  - `void write(char[] cbuf)`: Escreve caracteres de um array.
  - `void close()`: Fecha o stream e libera recursos associados.

---

### Classes Comuns de I/O

#### FileInputStream e FileOutputStream
- **FileInputStream**: Lê bytes de um arquivo.
- **FileOutputStream**: Escreve bytes em um arquivo.

#### FileReader e FileWriter
- **FileReader**: Lê caracteres de um arquivo.
- **FileWriter**: Escreve caracteres em um arquivo.

#### BufferedInputStream e BufferedOutputStream
- **BufferedInputStream**: Adiciona funcionalidade de buffer a um stream de entrada para melhorar a eficiência de leitura.
- **BufferedOutputStream**: Adiciona funcionalidade de buffer a um stream de saída para melhorar a eficiência de escrita.

#### BufferedReader e BufferedWriter
- **BufferedReader**: Adiciona funcionalidade de buffer a um reader para melhorar a eficiência de leitura e suporta métodos adicionais, como `readLine()`.
- **BufferedWriter**: Adiciona funcionalidade de buffer a um writer para melhorar a eficiência de escrita e suporta métodos adicionais, como `newLine()`.

### Exemplos de Uso✅

Aqui está um exemplo simples de como ler e escrever arquivos usando `FileReader` e `FileWriter`:

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOExample {
    public static void main(String[] args) {

        // Escrever em um arquivo
        try (FileWriter writer = new FileWriter("exemplo_bala.txt")) {
            writer.write("Pega!😎\n");
            writer.write("Bem vindo a leitura e escrita com Java☕");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ler de um arquivo
        try (FileReader reader = new FileReader("exemplo_bala.txt")) {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

---

## Java NIO (New I/O)

Java NIO (New I/O) foi introduzido no Java 1.4 e fornece um conjunto alternativo de APIs para I/O, focando em alta performance e operações não-bloqueantes. Principais componentes incluem:

- **Buffers**: Containers para dados.
- **Channels**: Representam conexões para I/O, tais como arquivos e sockets.
- **Selectors**: Permitem a verificação de múltiplos canais para I/O.

#### Exemplo Simples com NIO

```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioExample {
    public static void main(String[] args) {
        String data = "Olá mundo!🌎\nBem-vindo ao Java NIO.✍";
        try {
            Files.write(Paths.get("exemplo_bala.txt"), data.getBytes(), StandardOpenOption.CREATE);
            byte[] fileData = Files.readAllBytes(Paths.get("exemplo_bala.txt"));
            System.out.println(new String(fileData));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Resumo💯

Java fornece uma rica API para manipulação de I/O através dos pacotes `java.io` e `java.nio`. Enquanto `java.io` é mais simples e direto, `java.nio` oferece funcionalidades avançadas para aplicações que requerem alta performance e operações não-blocantes. A escolha entre os dois depende dos requisitos específicos do seu projeto.

---

### Atividade✍

De posse dos conhecimentos de I/O em java, utilize tais conceitos para criar uma aplicação que receba os dados do usuário e crie uma planilha de excel(.xls), onde recebe no mínimo três colunas do usuário e `N linhas` de dados, respectivos a quantidade de colunas informadas, ao final criar o arquivo da planilha.