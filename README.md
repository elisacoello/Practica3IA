# Practica 3: Aprendizaje Automático
##### Elisa Coello Valverde   

![licencia: ](/img/licencia.jpg)

1. **Elección del problema**
    
    Predicción de resultados de partidos en la ATP

2. **Fuente de datos escogida**

    Resultados de todos los partidos de la ATP de 2019
    
    Fuente de datos localizada en el siguiente repositorio:
    <https://github.com/JeffSackmann/tennis_atp/blob/master/atp_matches_2019.csv>

    Fichero csv dentro de la carpeta del proyecto : */dataset/atp_matches_2019.csv* 
    

3. **Características relevantes de los hechos**

    Para nuestro modelo de predicción de resultados de la ATP hemos tomado los siguientes atributos de la fuente de datos original:

    - **surface**: Superficie, la cual puede tomar los valores: {Hard,Clay,Grass}


    - **winner**: Ganador del partido de tenis, el cual puede tomar los valores: {Player1,Player2}


    - **winner_hand**: Mano del jugador que ha ganado el partido; puede ser diestro, zurdo o no conocido: {R,L,U}


    - **winner_age**: Edad del jugador que ha ganado el partido: {Número decimal}


    - **loser_hand**: Mano del jugador que ha perdido el partido; puede ser diestro, zurdo o no conocido: {R,L,U}


    - **loser_age**: Edad del jugador que ha perdido el partido: {Número decimal}


    - **w_ace**: Numero de ace´s (saques directos sin que la toque el rival) que ha realizado el jugador ganador del partido: {Número entero}

    
    - **w_SvGms**: Número de juegos con el servicio a favor jugados por el jugador ganador del partido (number of serve games): {Número entero}

    - **l_ace**:Numero de ace´s (saques directos sin que la toque el rival) que ha realizado el jugador perdedor del partido: {Número entero}


    - **l_SvGms**: Número de juegos con el servicio a favor jugados por el jugador perdedor del partido (number of serve games): {Número entero}


    - **winner_rank**: Ranking ATP del jugador ganador del partido en el momento en que se disputó dicho partido: {Número entero}

    - **loser_rank**: Ranking ATP del jugador perdedor del partido en el momento en que se disputó dicho partido: {Número entero}


    Habiendo elegido estas características relevantes para nuestro modelo de aprendizaje automático, elaboramos un nuevo archivo csv,
    que contiene únicamente estas carácterísticas: */dataset/caracteristicasRelevantesATP.csv*



4. **Obtención del fichero .arff**

    Fichero .arff con las características relevantes codificadas: */training-data/caracteristicasRelevantesATP.arff*

5. **Evaluación de los distintos algoritmos de aprendizaje automático con los datos obtenidos**

    Hemos evaluado los siguientes algoritmos de aprendizaje:
    
     - **Naive Bayes**

        ![resultado Naive Bayes: ](/img/ResultadoNaiveBayes.jpg)

     - **Random Forest**

         ![resultado Random Forest: ](/img/ResultadoRandomForest.jpg)


     - **ID3**

      ![resultado ID3: ](/img/ResultadoID3.jpg)

- Como se ve en la evaluación realizada con la herramienta *Weka*, el mejor algoritmo para nuestro modelo de predicción de resultados de los partidos de la ATP es el **Random Forest**


6. **Objeto serializado generado por Weka**

        Este objeto se genera al ejecutar la aplicación.

        *models/objetoRandomForestTenis.model*

7. **Aplicación pronosticador de partidos de la ATP**

Esta aplicación evalua el archivo *test-data\test_atp.arff* en el que se deberán indicar las características relevantes del partido para nuestro modelo:

![ImagenTest ](/img/test_atp.JPG)

Y a través de la aplicación del modelo, la aplicación nos mostrará quien ganará, Player 1 o Player 2

  - **Para compilar la aplicación**

        Ejecutar el comando *make* en el directorio raíz del proyecto
        Se crea el archivo ejecutable.jar si ha funcionado correctamente


  - **Ejecución de la aplicación**

Una vez se hayan indicado las carácterísticas del partido que queremos pronosticar en *test-data\test_atp.arff* **(respetando la sintaxis del archivo test_atp.arff)** procedemos a ejecutar la aplicación pronosticadora:
        
        java -jar ejecutable.jar

**El resultado es el pronóstico de que jugador ganará, el Player 1 o Player 2**


 ![ImagenResultado ](/img/ejecucion.png)




