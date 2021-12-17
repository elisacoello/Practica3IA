
package modelos;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;



public class ModeloRandomForest {



    private Instances leerInstancias(String ficherArff){
        try{
            Instances inst = new Instances(new BufferedReader(new FileReader(ficherArff)));
            inst.setClassIndex(inst.numAttributes() - 1);

            return inst;
        }catch (IOException ex) {
            Logger.getLogger(ModeloRandomForest.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public void aprenderModelo() {
        try {
            // crear RandomForest
            Classifier cls = new RandomForest();

            // train
            Instances inst = leerInstancias("./training-data/caracteristicasRelevantesATP.arff");
            cls.buildClassifier(inst);

            // serialize model
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./models/objetoRandomForestTenis.model")); 
            oos.writeObject(cls);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(ModeloRandomForest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String aplicarModelo() {
        try{
            String[] valoresAtributos = {"Player1", "Player2"};
            Classifier clasificador  = (Classifier) weka.core.SerializationHelper.read("./models/objetoRandomForestTenis.model");
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("./test-data/test_atp.arff");
            Instances data = source.getDataSet();
            data.setClassIndex(2);
            return valoresAtributos[(int) clasificador.classifyInstance(data.instance(0))];
        }catch (Exception ex) {
            Logger.getLogger(ModeloRandomForest.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al intentar leer el modelo";
        }
    }
    
}
