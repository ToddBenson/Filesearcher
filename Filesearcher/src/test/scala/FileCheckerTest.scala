package fileSearcher

import org.scalatest.FlatSpec
import java.io.File

class FilerCheckerTest extends FlatSpec{
  "FilterChecker passed a list where one file matches the filter" should
  "return a list with that file" in {
    val listOfFiles = List(FileObject(new File("random")), FileObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfFiles
    assert(matchedFiles == List(FileObject(new File("match"))))
  }
  "FileterChecker passed a list with a directory that matches the filter" should
  "should not return the directory" in {
    val listOfIOObjects = List(FileObject(new File("random")), new DirectoryObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles listOfIOObjects
    assert(matchedFiles.length == 0)
  }

  "FilterChecker passed a file with content that matches the filter 3 times" should
  "return a 3" in {
    val isContentMatched = FilterChecker("pluralsight").findMatchedContentCount(new File("./testFiles/pluralsight.data"))
    assert(isContentMatched == 3)
  }

  "FilterChecker passed a file with content that does not match the filter" should
  "return a 0" in {
    val isContentMatched = FilterChecker("pluralsight").findMatchedContentCount(new File("./testFiles/readme.txt"))
    assert(isContentMatched == 0)
  }
}
