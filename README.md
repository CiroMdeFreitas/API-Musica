
# API-Musica

Uma API inicialmente criada como trabalho final da School MJV, com o propósito de melhorar e aplicar os conhecimentos adquiridos no curso. Sua função é consumir um link ou arquivo JSON, providenciados por serviços como Spotify e Youtube Music, armazenado as informações de artistas, álbuns e musicas dentro de um banco de dados Postgres.

#### Módulos:

##### Spotify:

###### LEGENDA: ✔ Implementado | ⌚ Desenvolvimento | 📅 Planejado

- ⌚ Consumir um arquivo JSON de Playlist
- 📅 Consumir um arquivo JSON de Album
- 📅 Consumir um arquivo JSON de Artista/Banda
- 📅 Consumir um link de Playlist
- 📅 Consumir um link de Album
- 📅 Consumir um link de Artista/Banda

---

#### Dados

Segue a estrutura de dados que são armazenados pela API:

![imagem de uma diagrama UML, contendo as entidades que terão uma breve explicação abaixo.](diagram/diagram.png)

##### Artista

Possui todas as outras entidades, sua popularidade é gerada a partir de uma média da popularidade de todos álbuns que possui.

###### Consultas:

- /artistas - Retorna todos artistas registrados;
- /artistas/top10 - Retorna os 10 artistas mais populares;
- /artistas/{id} - Retorna o artista com o id fornecido;
- /artistas/{id}/albuns - Retorna todos os álbuns do artista solicitado;
- /artistas/{id}/albuns/top5 - Retorna os 5 álbuns mais polulares do artista solicitado;
- /artistas/{id}/musicas - Retorna todas as músicas do artista solicitado;
- /artistas/{id}/musicas/top10 - Retorna as 10 músicas mais populares do artista solicitado;
- /artistas/{id}/origens - Retorna todas as origens do artista solicitado;

##### Album

Possui uma coleção de musicas, sua popularidade é gerada a partir de uma média da popularidade de todas músicas que possui.

###### Consultas:

- /albuns - Retorna todos álbuns registrados;
- /albuns/top10 - Retorna os 10 álbuns mais populares;
- /albuns/{id} - Retorna o álbum com o id fornecido;
- /albuns/{id}/musicas - Retorna todas as músicas do álbum solicitado;
- /albuns/{id}/musicas/top - Retorna a música mais popular do álbum solicitado;
- /albuns/{id}/origens - Retorna todas origens do álbum solicitado;

##### Musica

Responsável por fornecer popularidade, o que permiti definir o quão popular é todas as outras entidades.

###### Consultas:

- /musicas - Retorna todas musicas registradas;
- /musicas/top10 - Retorna as 10 musicas mais populares;
- /musicas/{id} - Retorna a musica com o id fornecido;
- /musicas/{id}/origens - Retorna todas as origens da musica solicitado;

##### Origem

Representa de qual plataforma originou a entidade, tem papel fundamental para evitar duplicidade de registros vindo de uma mesma plataforma.

###### Consultas:

- /origens- Retorna todas as origens registradas;
- /origens/{id} - Retorna a origem com o id fornecido;

---