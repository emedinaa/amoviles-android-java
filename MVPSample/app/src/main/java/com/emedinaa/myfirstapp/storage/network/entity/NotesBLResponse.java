package com.emedinaa.myfirstapp.storage.network.entity;

import com.emedinaa.myfirstapp.model.NoteBLEntity;

import java.util.ArrayList;

/**
 * Created by emedinaa on 10/11/17.
 */
/*
[
    {
        "created": 1510361481105,
        "updated": null,
        "ownerId": null,
        "objectId": "C71B2839-0019-27F8-FF2B-9B6ABC662E00",
        "description": "My nota de prueba",
        "title": "Nueva nota",
        "___class": "Note",
        "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"created\",\"updated\",\"ownerId\",\"objectId\",\"description\",\"title\",\"___class\"],\"relatedObjects\":{}}"
    },
    {
        "created": 1510361493828,
        "updated": null,
        "ownerId": null,
        "objectId": "D3E98E27-104C-E761-FF24-2915A41E8D00",
        "description": "Otra nota",
        "title": "Nueva nota 2",
        "___class": "Note",
        "__meta": "{\"relationRemovalIds\":{},\"selectedProperties\":[\"created\",\"updated\",\"ownerId\",\"objectId\",\"description\",\"title\",\"___class\"],\"relatedObjects\":{}}"
    }
]
 */
public class NotesBLResponse extends ArrayList<NoteBLEntity> {}
