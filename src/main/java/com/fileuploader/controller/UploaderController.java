package com.fileuploader.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(path = "/api")
public class UploaderController {

	private static String SAVE_FOLDER = "C://workspaces//temp//";

	@PostMapping("/files")
	public ResponseEntity<String> singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			String fileEmpty = "Please select a file to upload";
			return ResponseEntity.status(HttpStatus.OK).body(fileEmpty);
		}

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(SAVE_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

			String message1 = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message1);

		} catch (Exception e) {
			String error = "FAIL to upload " + file.getOriginalFilename() + "!" + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(error);
		}

	}

}
