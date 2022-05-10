# Futsal

La asociación argentina de futsal está queriendo realizar un salto de calidad en sus
competiciones. Para eso nos contrata para desarrollar el software que les permita anotar
las estadísticas de los partidos que se juegan en sus torneos.
Nos comentan que estos torneos están compuestos por 25 equipos que coinciden con los
equipos de primera división de AFA (Asociación de Fútbol Argentino).
Para simplificar las pruebas de nuestra primera versión del software acordamos que sólo
se cargarán 5 jugadores por equipo, siendo información relevante el precio y la edad de los
jugadores que competirán.
Las funcionalidades principales que debe tener el software son las siguientes:
1. Agregar los jugadores a los equipos (los equipos no es necesario dar de alta
porque se conforman previo al inicio de la competencia, es decir contaremos de
antemano con esa información).
2. Calcular el valor del equipo, esto es la sumatoria del precio de cada jugador.
3. Calcular la edad promedio del equipo.
4. Registrar un nuevo partido. En él se debe poder incorporar al local y al visitante.
Una vez creado el partido, se nos solicita poder registrar los siguientes eventos:
a. Gol, se interesa conocer el autor y el minuto en el que ocurrió
b. Amonestados, se desea conocer el jugador amonestado y en qué minuto
(cuando un jugador es amonestado en dos oportunidades
automáticamente debe ser expulsado, y se espera que el sistema informes
esta situación).
c. Expulsados, ya sea por doble amonestación o por expulsión directa, se
debe conocer los jugadores que son expulsados del partido.
Ver el resumen. En este resumen se espera conocer el resultado del partido, y el
detalle de los autores de los goles, amonestados y expulsados
