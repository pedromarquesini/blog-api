Criar uma API que forneça um serviço para um blog. A API deve utilizar um banco de dados a sua escolha. 

O blog consiste nas seguintes entidades:

- Autor 
    - É importante saber o nome e uma breve descrição de cada autor
    - Um autor pode escrever várias postagens

- Postagem
    - Em cada postagem é importante saber o título, o conteúdo, a data, as categorias, o autor e a quantidade de vezes que a postagem foi exibida.
    - Uma postagem possuí apenas um autor, mas pode pertencer a várias categorias.

- Categoria
    - É importante saber o nome de cada categoria.
    - Categorias podem ter sub-categorias


A API deve implementar as seguintes features:

- CRUD Autor.
    - Deve ser possível Cadastrar/Ver/Alterar/Apagar um autor específico.
    - Deve ser possível listar todos os autores.

- CRUD Postagem.
    - Deve ser possível Cadastrar/Ver/Alterar/Apagar uma postagem específica.

- CRUD Categoria.
    - Deve ser possível Cadastrar/Ver/Alterar/Apagar uma categoria específica.
    - Deve ser possível listar todas as categorias.

- Listar todos as postagens de um determinado autor ou categoria.

- Os resultados de listagem devem ter parâmetros para paginar os resultados.

- Todas as requisições devem retornar os resultados em JSON
