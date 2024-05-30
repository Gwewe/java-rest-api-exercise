package com.cbfacademy.restapiexercise.ious;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/ious")
public class IOUController {
    private final IOUService iouService;

    public IOUController(IOUService iouService) {
        this.iouService = iouService;
        //Constructor.
    }

    //     Method	URL	Description

    //to get all IOUs.

    @GetMapping
    public ResponseEntity<List<IOU>> getAllIOUs() {
        try {
            List<IOU> ious = iouService.getAllIOUs();
            return ResponseEntity.ok(ious);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

        // to get an IOU by id
    @GetMapping("/{id}")
    public ResponseEntity <IOU> getIOU(@PathVariable UUID id) {
            try {
                IOU iou = iouService.getIOU(id);
                return ResponseEntity.ok(iou);
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        }
    
    
    // POST	/api/ious	Add an IOU
    @PostMapping
    public ResponseEntity<IOU> createIOU(@RequestBody IOU iou) {
        try {
            IOU createdIOU = iouService.createIOU(iou);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIOU);
        } 
        catch (IllegalArgumentException e) {
            System.err.println("Failed to create the IOU.");
            return ResponseEntity.badRequest().build();
        }
    }
    // PUT	/api/ious/{id}	Replace an IOU by Id
    @PutMapping //("/{id}")
    public ResponseEntity <IOU> updateIOU(@PathVariable UUID id, @RequestBody IOU updatedIOU) {
        try {
            IOU iou = iouService.updateIOU(id, updatedIOU);
            return ResponseEntity.ok(updatedIOU);
        } catch (NoSuchElementException e) {
            return ResponseStatusException(HttpStatus.NOT_FOUND).body(updatedIOU);
        }
    }
    // DELETE	/api/ious/{id}	Delete an IOU by id
}
