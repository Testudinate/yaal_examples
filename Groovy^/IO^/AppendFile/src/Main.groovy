File file;
L1:{
	//Готовим базовый файл
	file = File.createTempFile("AppendFile",".tmp")
	println(file.absolutePath)
	//file.deleteOnExit() 
	file.withWriter { out ->
	   out.writeLine('К этому файлу будет дописано контент.\n')
	}
	println("old length=${file.length()}")
}

L2:{
	File baseFile = new File(file.absolutePath)

	//Дописываем текст в конец базового файла
	String appendix = this.getClass().getResource('appendix.txt').text
	baseFile.append(appendix)

	println("new length=${baseFile.length()}")
}