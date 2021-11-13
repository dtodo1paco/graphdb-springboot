package org.dtodo1paco.samples.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

  public FileUtils() {
    throw new UnsupportedOperationException("FileUtils cannot be instantiated");
  }

  public static String readFile (String filename) {
    String content = StringUtils.EMPTY;
    try {
      File file = ResourceUtils.getFile("classpath:"+filename);
      Stream<String> lines = Files.lines(file.toPath());
      content = lines.collect(Collectors.joining("\r\n"));
    } catch (IOException e) {
      logger.error("Unable to read file " + filename + ": " + e.getMessage(), e);
    }
    return content;
  }

  private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

}
