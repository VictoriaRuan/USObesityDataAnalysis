import java.util.*;
import java.io.*;

//Driver method
public class obesitySort{
  public static void main(String[] args) throws Exception{
    ArrayList<County> countyList = new ArrayList<>();
    Scanner sc = new Scanner(new File("RISKFACTORSANDACCESSTOCARE.csv"));
    FileWriter output = new FileWriter("obesityDataAnalysis.txt");
    int top = 20;
    sc.nextLine();
    while(sc.hasNextLine()){
      String newCounty = sc.nextLine();
      String[] splitNewCounty = newCounty.split(",");
      countyList.add(new County(splitNewCounty));
    }
    sc.close();
    
    
    //Indicator 1
    Collections.sort(countyList, new SortByNoExercise());
    output.write("The top " + top + " counties sorted based on No Exercise"); 
    for(int i=0; i<top; i++)
      output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).noExercise); 
    /*output.write("\n\nThe bottom top counties sorted by No Exercise\n"); 
    for(int i=countyList.size()-top; i<countyList.size(); i++)
      output.write("\n" +(21 - countyList.size()+i)+ ". " + countyList.get(i) + countyList.get(i).noExercise);*/
    
    
    
    //Indicator 2
    Collections.sort(countyList, new SortByFewFruitVeg());
    output.write("\n\n\nThe top " + top + " counties sorted based on Few Fruit & Vegetables");
   for(int i=0; i<top; i++)
      output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).fewFruitVeg); 
    
    //Indicator 3
    Collections.sort(countyList, new SortByObesity());
    output.write("\n\n\nThe top " + top + " counties sorted based on Obesity");
    for(int i=0; i<top; i++)
      output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).obesity); 
    
    //Indicator 4
    Collections.sort(countyList, new SortByHighBloodPressure());
    output.write("\n\n\nThe top " + top + " counties sorted based on High Blood Pressure");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).highBloodPressure); 
    
    //Indicator 5
    Collections.sort(countyList, new SortBySmoker());
    output.write("\n\n\nThe top " + top + " counties sorted based on Smoker");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).smoker); 
    
    //Indicator 6
    Collections.sort(countyList, new SortByDiabetes());
    output.write("\n\n\nThe top " + top + " counties sorted based on Diabetes");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).diabetes); 
    
    //Indicator 7
    Collections.sort(countyList, new SortByUninsured());
    output.write("\n\n\nThe top " + top + " counties sorted based on Uninsured");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).uninsured); 
    
    //Indicator 8
    Collections.sort(countyList, new SortByElderlyMedicare());
    output.write("\n\n\nThe top " + top + " counties sorted based on Elderly Medicare");
     for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).elderlyMedicare); 
    
    //Indicator 9
    Collections.sort(countyList, new SortByDisabledMedicare());
    output.write("\n\n\nThe top " + top + " counties sorted based on Disabled Medicare");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).disabledMedicare); 
    
    
    //Indicator 10
    Collections.sort(countyList, new SortByPrimaryCarePhysicianRate());
    output.write("\n\n\nThe top " + top + " counties sorted based on Primary Care Physician Rate");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).primaryCarePhysicianRate); 
    
    //Indicator 11
    Collections.sort(countyList, new SortByDentistRate()); 
    output.write("\n\n\nThe top " + top + " counties sorted based on Dentist Rate");
    for(int i=0; i<top; i++)
       output.write("\n" + (i+1)+ ". " + countyList.get(i) + countyList.get(i).dentistRate); 

    
    output.close();
  }
}




// County object implementation
class County{
    public String[] countyInfo;
    public String countyName,stateName;
    public double noExercise,fewFruitVeg,obesity,highBloodPressure,smoker,diabetes,primaryCarePhysicianRate,dentistRate;
    public int countyID,uninsured,elderlyMedicare,disabledMedicare,communityHealthCenter,indiHPSA;
    public County(String[] countyInfo){
      this.countyInfo = countyInfo;
      countyName = countyInfo[0];
      stateName = countyInfo[1];
      countyID = Integer.parseInt(countyInfo[2]);
      noExercise = Double.parseDouble(countyInfo[3]);
      fewFruitVeg = Double.parseDouble(countyInfo[4]);
      obesity = Double.parseDouble(countyInfo[5]);
      highBloodPressure = Double.parseDouble(countyInfo[6]);
      smoker = Double.parseDouble(countyInfo[7]);
      diabetes = Double.parseDouble(countyInfo[8]);
      uninsured = Integer.parseInt(countyInfo[9]);
      elderlyMedicare = Integer.parseInt(countyInfo[10]);
      disabledMedicare = Integer.parseInt(countyInfo[11]);
      primaryCarePhysicianRate = Double.parseDouble(countyInfo[12]);
      dentistRate = Double.parseDouble(countyInfo[13]);
      communityHealthCenter = Integer.parseInt(countyInfo[14]);
      indiHPSA = Integer.parseInt(countyInfo[15]);
    }
    
    
    @Override
    public String toString(){
      return countyName + " " + stateName + " ";
    }
  }




// Different comparators for sorting the arraylist
class SortByNoExercise implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.noExercise - a.noExercise)*10);
  }
}

class SortByFewFruitVeg implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.fewFruitVeg - a.fewFruitVeg)*10);
  }
}

class SortByObesity implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.obesity - a.obesity)*10);
  }
}

class SortByHighBloodPressure implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.highBloodPressure - a.highBloodPressure)*10);
  }
}

class SortBySmoker implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.smoker - a.smoker)*10);
  }
}

class SortByDiabetes implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.diabetes - a.diabetes)*10);
  }
}

class SortByUninsured implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.uninsured - a.uninsured)*10);
  }
}

class SortByElderlyMedicare implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.elderlyMedicare - a.elderlyMedicare)*10);
  }
}

class SortByDisabledMedicare implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.disabledMedicare - a.disabledMedicare)*10);
  }
}

class SortByPrimaryCarePhysicianRate implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.primaryCarePhysicianRate - a.primaryCarePhysicianRate)*10);
  }
}

class SortByDentistRate implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.dentistRate - a.dentistRate)*10);
  }
}

class SortByCommunityHealthCenter implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.communityHealthCenter - a.communityHealthCenter)*10);
  }
}

class SortByIndiHPSA implements Comparator<County>{
  @Override
  public int compare(County a, County b){
    return (int)((b.indiHPSA - a.indiHPSA)*10);
  }
}






