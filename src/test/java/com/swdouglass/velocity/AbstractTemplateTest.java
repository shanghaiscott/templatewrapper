/*
 * Copyright 2010, Scott Douglass <scott@swdouglass.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * on the World Wide Web for more details:
 * http://www.fsf.org/licensing/licenses/gpl.txt
 */

package com.swdouglass.velocity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.Ignore;

/**
 *
 * @author scott
 */
@Ignore
public abstract class AbstractTemplateTest {
  private String mergeResult;
  private String expectedMergeResult;

  public void loadExpectedResult() {
    try {
      expectedMergeResult = readFile("src/test/resources/test1.txt");
    } catch (IOException e) {
      System.out.println("reading expected result failed.");
      System.out.println(e);
    }
  }
  /**
   * @return the mergeResult
   */
  public String getMergeResult() {
    return mergeResult;
  }

  /**
   * @param mergeResult the mergeResult to set
   */
  public void setMergeResult(String mergeResult) {
    this.mergeResult = mergeResult;
  }

  /**
   * @return the expectedMergeResult
   */
  public String getExpectedMergeResult() {
    return expectedMergeResult;
  }

  /**
   * @param expectedMergeResult the expectedMergeResult to set
   */
  public void setExpectedMergeResult(String expectedMergeResult) {
    this.expectedMergeResult = expectedMergeResult;
  }

  public static String readFile(String pathname) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    try (Scanner scanner = new Scanner(new File(pathname))) {
      while (scanner.hasNextLine()) {
        stringBuilder.append(scanner.nextLine());
        stringBuilder.append("\n");
      }
    }
    return stringBuilder.toString();
  }
  
  public String getPath(final String inPartialPath) {
    Path p = Paths.get("src","test","resources", inPartialPath);
    return p.toString();
  }
}
