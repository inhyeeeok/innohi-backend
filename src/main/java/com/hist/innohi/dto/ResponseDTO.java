package com.hist.innohi.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	private String error;
	private boolean successYn;
	private List<T> data;
	private final String timestamp = SimpleDateFormat();
	
	private String SimpleDateFormat() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		return sdf.format(timestamp);
	}
}

