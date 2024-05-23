package com.cbfacademy.restapiexercise.ious;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class ListIOUService implements IOUService {
    private final List<IOU> ious = new ArrayList<>();
    private final IOURepository iouRepository;


    public ListIOUService (IOURepository iouRepository) {
        this.iouRepository = iouRepository;
    }

    @Override
    public List<IOU> getAllIOUs() {
        try {
            return new ArrayList<>(ious);
        } catch (Exception e) {
            System.err.println("List of ious not found or does not exist.");
            return null;
        }
    }


    @Override
    public IOU getIOU(UUID id){
        try {
            return iouRepository.getIOU(id);
        } catch (NoSuchElementException e) {
            System.err.println(id + " : the id was not found or does not exist.");
            return null;
        }

    }

    @Override
    public IOU createIOU(IOU iou) {
        ious.add(iou);
        try {
            return iouRepository.save(iou);
        } 
        catch (IllegalArgumentException e) {
            System.err.println("Failed to create the IOU.");
            return null;
        }
    }


    @Override
    public updateIOU(UUID id, IOU updatedIOU) {
        updateIOU.id = this.id;
        try{
            return iouRepository.getIOU(updateIOU);

        }
        catch (NoSuchELementException e){
            System.err.println("Failed to update the IOU : There is no such element");
            return null;
        }
        
    }


}
