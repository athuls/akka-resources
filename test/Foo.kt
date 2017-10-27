class Foo {
  companion object {
     @JvmStatic
     fun a() : Int {
	println("Printing from Kotlin:");
	println("Sending number to SALSA code: " + 234);
	println();
	return 234;
	}
  }
}
