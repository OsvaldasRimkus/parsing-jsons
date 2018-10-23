package lt.orimkus.someTask;
/**
 * @author Osvaldas Rimkus
 * @since 2018-10-21
 */
public class DriverJsonParser {

	public DriverInfo resolveDriver(String json) {
		
		DriverInfo info = new DriverInfo();
		
		String[] parsedJson = json.split(",");
		
		for (int i = 0; i < parsedJson.length; i++) {
			String tempString = parsedJson[i].trim();
			String[] dataArray = tempString.split(":");
			String key = dataArray[0].substring(dataArray[0].indexOf('"')+1, dataArray[0].lastIndexOf('"'));
			String value;
			if (i == 0){
				value = dataArray[1].substring(dataArray[0].indexOf('"'), dataArray[0].lastIndexOf('"')-1);
			}else {
				value = dataArray[1];
			}
			
			switch (key) {
				case "name" : info.setName(value);
				break;
				case "age" : info.setAge(Integer.parseInt(value));
				break;
				case "car" :
					if (value.length()>1){
						info.setNumberOfCars(Integer.parseInt(value.substring(0, value.length()-1)));
					} else {
						info.setNumberOfCars(0);
					}
					
			}
		}
		if (info.getNumberOfCars() != 0){
			System.out.println("User " + info.getName() + ", who is " + info.getAge() + " years old has " + info.getNumberOfCars() + " cars");
		} else {
			System.out.println("User " + info.getName() + ", who is " + info.getAge() + " years old has no cars");
		}
		
		
		return info;
	}
	
}
