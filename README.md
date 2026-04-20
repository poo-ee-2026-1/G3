# GRUPO 3
##  Projeto de Sistema de Biblioteca
Participantes: Victor Giuliano Novaes, Mariana Sousa e Taís dos Santos.


**OBJETIVO**  
Este projeto será desenvolvido em Java, visando colocar em prática os conceitos de programação orientada à objetos, o trabalho consiste em um sistema de biblioteca que visa a organização de livros - vizualização de acervo, pesquisa de títulos, empréstimo e controle de disponibilidade.

|**FUNCIONALIDADES**||
|----|----|
| Acervo de livros | Pesquisa de títulos, autores e códigos|  
| Cadastro de títulos | Adicionar e retirar livros do acervo|  
| Controle de disponibilidade | Datas de devolução, disponibilidade de títulos|   
| Sistema de empréstimo | Alterar status do livro (indisponíivel/disponível) e cobrança por atraso|  

**CRONOGRAMA**  
|PRAZO|DESCRIÇÃO|
|---|---|
|1ª Entrega (23/03)| Rascunho inicial do projeto e read.me, cronograma e divisão de tarefas|  
|2ª Entrega (06/04)| Catálogo base de livros e funcionalidade - acervo|  
|3ª Entrega (20/04)| Funcionalidade - cadastro de livros|  
|4ª Entrega (04/05)| Funcionalidade - empréstimo e controle de disponibilidade|  
|5ª Entrega (18/05)| Testagem, revisão de projeto e conclusão de read.me|  
|Entrega Final (01/06)| Apresentação do projeto completo e revisado|

**CLASSES**  
Por enquanto nossas classes principais são Biblioteca, Livro e Serviços.

**PILARES DE POO**  
-ENCAPSULAMENTO   
O encapsulamento está presente na classe Livro, onde todos os atributos são declarados como private, impedindo o acesso direto a eles. Para ler ou modificar esses dados, é necessário utilizar os métodos getters e setters, como getTitulo() e setDisponibilidade(), protegendo assim as informações do objeto.

-ABSTRAÇÃO  
A abstração aparece na separação de responsabilidades entre as classes. A classe Serviços concentra as operações do sistema, como adicionar e listar livros, enquanto a classe Livro representa apenas os dados relevantes de um livro. Com isso, o método main não precisa saber como cada operação funciona, apenas as chama quando necessário.

-HERANÇA  
Ainda será adicionada...

-POLIMORFISMO  
O polimorfismo aparece na classe Livro através da sobrescrita do método toString() com a anotação @Override. O método original, herdado de Object, foi reescrito com um comportamento personalizado para exibir os dados do livro. Assim, quando o método é chamado na listagem, o Java utiliza automaticamente essa versão personalizada no lugar da original.
