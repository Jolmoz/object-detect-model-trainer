package com.jolmoz.objectdetectmodeltrainer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jolmoz.objectdetectmodeltrainer.control.AuthenticationControl;
import com.jolmoz.objectdetectmodeltrainer.control.ModelManagerControl;
import com.jolmoz.objectdetectmodeltrainer.dtos.AssetDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.AssetDocumentDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.DataSetDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.ModelDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.RegionDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.TagDTO;
import com.jolmoz.objectdetectmodeltrainer.dtos.UserAccessDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ModelManagerServerApi")

public class ModelManagerServerApi {

	@Autowired
	AuthenticationControl authControl;

	@Autowired
	ModelManagerControl modelControl;

	@GetMapping("/getAllModels")
	public ResponseEntity<List<ModelDTO>> getAllModels(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<ModelDTO>>((List<ModelDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllModels(token);
	}

	@PostMapping("/saveModel")
	public ResponseEntity<ModelDTO> saveModel(@RequestHeader String token, @RequestBody ModelDTO modelDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<ModelDTO>((ModelDTO) null, HttpStatus.UNAUTHORIZED);
		}
		if (modelDTO.getUserAccessCreator() == null) {
			modelDTO.setUserAccessCreator(user.getBody());
		}
		modelDTO.setUserAccessLastEditor(user.getBody());
		return modelControl.saveModel(modelDTO);
	}

	@DeleteMapping("/deleteModel")
	public ResponseEntity<Boolean> deleteModel(@RequestHeader String token, @RequestBody ModelDTO modelDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteModel(modelDTO);
	}

	@GetMapping("/getAllDataSets")
	public ResponseEntity<List<DataSetDTO>> getAllDataSets(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<DataSetDTO>>((List<DataSetDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllDataSets(token);
	}

	@PostMapping("/saveDataSet")
	public ResponseEntity<DataSetDTO> saveDataSet(@RequestHeader String token, @RequestBody DataSetDTO dataSetDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<DataSetDTO>((DataSetDTO) null, HttpStatus.UNAUTHORIZED);
		}
		if (dataSetDTO.getUserAccessCreator() == null) {
			dataSetDTO.setUserAccessCreator(user.getBody());
		}
		dataSetDTO.setUserAccessLastEditor(user.getBody());
		return modelControl.saveDataSet(dataSetDTO);
	}

	@DeleteMapping("/deleteDataSet")
	public ResponseEntity<Boolean> deleteDataSet(@RequestHeader String token, @RequestBody DataSetDTO dataSetDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteDataSet(dataSetDTO);
	}

	@GetMapping("/getAllAssetDocuments")
	public ResponseEntity<List<AssetDocumentDTO>> getAllAssetDocuments(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<AssetDocumentDTO>>((List<AssetDocumentDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllAssetDocumentDTOs();
	}

	@PostMapping(value = "/saveAssetDocument")
	public ResponseEntity<AssetDocumentDTO> saveAssetDocument(@RequestHeader String token,
			@RequestBody AssetDocumentDTO assetDocumentDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<AssetDocumentDTO>((AssetDocumentDTO) null, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.saveAssetDocument(assetDocumentDTO);
	}

	@PostMapping(value = "/uploadAssetDocument")
	public ResponseEntity<AssetDocumentDTO> uploadAssetDocument(@RequestHeader String token,
			@RequestParam("assetDocumentId") long assetDocumentDTO, @RequestParam("file") MultipartFile file) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<AssetDocumentDTO>((AssetDocumentDTO) null, HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<AssetDocumentDTO>((AssetDocumentDTO) null, HttpStatus.UNAUTHORIZED);
	}

	@DeleteMapping("/deleteAssetDocument")
	public ResponseEntity<Boolean> deleteAssetDocument(@RequestHeader String token,
			@RequestBody AssetDocumentDTO assetDocumentDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteAssetDocument(assetDocumentDTO);
	}

	@GetMapping("/getAllAssets")
	public ResponseEntity<List<AssetDTO>> getAllAssets(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<AssetDTO>>((List<AssetDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllAssetDTOs();
	}

	@PostMapping("/saveAsset")
	public ResponseEntity<AssetDTO> saveAsset(@RequestHeader String token,
			@RequestBody AssetDTO assetDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<AssetDTO>((AssetDTO) null, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.saveAsset(assetDTO);
	}

	@DeleteMapping("/deleteAsset")
	public ResponseEntity<Boolean> deleteAsset(@RequestHeader String token,
			@RequestBody AssetDTO assetDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteAsset(assetDTO);
	}

	@GetMapping("/getAllTags")
	public ResponseEntity<List<TagDTO>> getAllTags(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<TagDTO>>((List<TagDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllTagDTOs();
	}

	@PostMapping("/saveTag")
	public ResponseEntity<TagDTO> saveTag(@RequestHeader String token,
			@RequestBody TagDTO tagDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<TagDTO>((TagDTO) null, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.saveTag(tagDTO);
	}

	@DeleteMapping("/deleteTag")
	public ResponseEntity<Boolean> deleteTag(@RequestHeader String token,
			@RequestBody TagDTO tagDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteTag(tagDTO);
	}

	@GetMapping("/getAllRegions")
	public ResponseEntity<List<RegionDTO>> getAllRegions(@RequestHeader String token) {
		try {
			ResponseEntity<UserAccessDTO> user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<List<RegionDTO>>((List<RegionDTO>) null, HttpStatus.UNAUTHORIZED);
		}

		return modelControl.getAllRegionDTOs();
	}

	@PostMapping("/saveRegion")
	public ResponseEntity<RegionDTO> saveRegion(@RequestHeader String token,
			@RequestBody RegionDTO regionDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<RegionDTO>((RegionDTO) null, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.saveRegion(regionDTO);
	}

	@DeleteMapping("/deleteRegion")
	public ResponseEntity<Boolean> deleteRegion(@RequestHeader String token,
			@RequestBody RegionDTO regionDTO) {
		ResponseEntity<UserAccessDTO> user = null;
		try {
			user = authControl.verifyToken(token);
			if (!user.getStatusCode().equals(HttpStatus.OK)) {
				throw new IllegalAccessException();
			}
		} catch (IllegalAccessException e) {
			return new ResponseEntity<Boolean>(false, HttpStatus.UNAUTHORIZED);
		}
		return modelControl.deleteRegion(regionDTO);
	}

}
