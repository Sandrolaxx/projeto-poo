## Sistema conversor💱

Nosso sistema conversor vai possuir duas funcionalidades, conversão de números inteiros para romanos e conversor de moedas("USD", "EUR", "JPY", "GBP", "BRL").

---

### **1º Funcionalidade: Conversão de números inteiros para números romanos**

**📝Objetivo:**  
Entender e implementar um algoritmo que converta números inteiros para sua representação equivalente em números romanos, utilizando arrays para mapeamento e laços de repetição.

**📃Descrição:**  
Você deve implementar um programa em Java que converta números inteiros no intervalo de 1 a 3999 para a sua respectiva representação em números romanos. O programa deve solicitar ao usuário um número e exibir a conversão correspondente. Para mais sobre lógica do [conversor números romanos](https://conversorromano.com.br/algoritmo.html).

**Direcionamento para resolução:**

1. **Identifique as unidades básicas:**
   - Reflita sobre como os números romanos são compostos e quais são os símbolos e valores básicos (por exemplo, I = 1, V = 5, X = 10, etc.).
   - Crie dois arrays: um para armazenar os valores numéricos e outro para armazenar os símbolos romanos correspondentes.

2. **Crie um método para a conversão:**
   - Implemente um método chamado `toRoman` que receba um número inteiro e retorne uma string representando o número em formato romano.

3. **Construa a lógica de subtração**

**Exemplo de saída esperada:**
```
Digite um número para converter para números romanos (1-3999): 1987
O número 1987 em números romanos é: MCMLXXXVII
```

**Dicas💡:**
- Lembre-se de que os números romanos são lidos da maior unidade para a menor.
- Não esqueça de lidar com os casos especiais, como 4 (IV) e 9 (IX), que não seguem a regra de adição direta.

Esta atividade ajudará você a consolidar conceitos de arrays, laços de repetição, manipulação de strings e lógica de programação.

--- 

### **2º Funcionalidade:: Conversor de moedas**

**📝Objetivo:**  
Implementar um programa em Java que converta valores entre diferentes moedas utilizando taxas de câmbio pré-definidas. A atividade permitirá que você pratique arrays, loops, manipulação de strings e tratamento de erros.

**📃Atividade:**  
Você deve criar um programa que converta um valor de uma moeda para outra, com base em um conjunto fixo de moedas e suas respectivas taxas de câmbio em relação ao dólar americano (USD). O programa deve receber a moeda de origem, a moeda de destino e o valor a ser convertido, e então exibir o valor convertido.

**Passos para a resolução:**

1. **Compreenda o problema:**
   - Analise as taxas de câmbio fornecidas e como elas se relacionam com a moeda base (USD).
   - Entenda como utilizar essas taxas para converter entre duas moedas diferentes.

2. **Declare as moedas e as taxas de câmbio:**
   - Crie dois arrays estáticos: um para armazenar os códigos das moedas suportadas e outro para armazenar as respectivas taxas de câmbio em relação ao USD.
   - Exemplo: `"USD", "EUR", "JPY", "GBP", "BRL"` e taxas correspondentes `1.0, 0.85, 110.0, 0.75, 5.4`.

3. **Implemente o método de conversão:**
   - Crie um método `convert(double amount, String fromCurrency, String toCurrency)` que realiza a conversão entre as moedas.
   - Use o método `findCurrencyIndex(String currency)` para localizar o índice das moedas nos arrays.

4. **Trate erros de entrada:**
   - Se o código da moeda de origem ou destino não for encontrado, exiba uma mensagem de erro apropriada.
   - Utilize exceções (`IllegalArgumentException`) para lidar com entradas inválidas.

5. **Teste o programa:**
   - No método `main`, crie alguns exemplos de conversão e imprima os resultados no console.
   - Verifique se as conversões estão corretas e se o programa trata adequadamente os casos de erro.

**Exemplo de entrada/saída:**
```plaintext
100 USD em EUR: 85.0
100 EUR em JPY: 12941.18
100 USD em BRL: 540.0
100 BRL em GBP: 13.89
```

**Dicas💡:**
- Lembre-se de que a taxa de câmbio é relativa ao USD. Se você está convertendo de EUR para JPY, primeiro converta EUR para USD e depois USD para JPY.
- Certifique-se de que o programa pode lidar com quaisquer moedas especificadas no array de moedas.

Essa atividade permitirá que você aplique conceitos básicos de arrays, laços e tratamento de exceções, além de manipular lógica de negócios simples em Java.

---

🎯 Desafio

Formate os valores de moeda em `R$` utilizando as classes [NumberFormat](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html) e [Locale](https://docs.oracle.com/javase/8/docs/api/java/util/Locale.html).