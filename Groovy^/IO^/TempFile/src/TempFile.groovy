File.createTempFile("temp",".scrap").with {
    deleteOnExit()
    write "Hello world"
    println absolutePath
}