package com.eugenep.catalog.parser;

import java.io.InputStream;
import java.util.List;

public interface FileParser<T> {

    List<T> parse(InputStream inputStream);
}
