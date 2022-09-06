import scala.io.StdIn.readLine

object Main {
  val _alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

  val encrypt = (c:Char, key:Int, a:String) =>
    a((a.indexOf(c.toUpper) + key + a.length) % a.length)

  val decrypt = (c:Char, key:Int, a:String) =>
    a((a.indexOf(c.toUpper) - key + a.length) % a.length)

  val cipher = (algo:(Char, Int, String) => Char, targetStr:String, key:Int, alphabet:String) =>
    targetStr.map(algo(_, key, alphabet))

  def main(args: Array[String]): Unit = {
    val str = readLine("Enter the string: ")
    val shift = readLine("Shift By: ").toInt


    val ct = cipher(encrypt, str, shift, _alphabet)
    val pt = cipher(decrypt, ct, shift, _alphabet)

    println("Encrypted text: " + ct)
    println("Decrypted text: " + pt)
  }
}