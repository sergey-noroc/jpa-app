package com.snoroc.domain.graph;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NamedEntityGraphs({
        //Картинки и Тэги нужно загружать EAGER
        @NamedEntityGraph(name = "post-entity-graph", attributeNodes = { @NamedAttributeNode(value = "images"),
                                                                         @NamedAttributeNode(value = "tags")} ),
})
@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "post")
    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    @ElementCollection
    private Set<String> tags = new HashSet<>();

}
