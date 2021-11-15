package org.dtodo1paco.samples.graphdb.model.projections;

import lombok.Value;

import java.util.Map;

@Value
public class ItemProperties {
  Map<String, Object> item;
}
