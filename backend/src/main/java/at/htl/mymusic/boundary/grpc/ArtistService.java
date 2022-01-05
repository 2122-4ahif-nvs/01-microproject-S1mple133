package at.htl.mymusic.boundary.grpc;

import at.htl.mymusic.Artist;
import at.htl.mymusic.ArtistReply;
import at.htl.mymusic.ArtistRequest;
import at.htl.mymusic.ArtistSeeker;
import at.htl.mymusic.control.ArtistRepository;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;

@GrpcService
public class ArtistService implements ArtistSeeker {
    @Inject
    ArtistRepository repository;

    @Override
    @Blocking
    public Uni<ArtistReply> getArtist(ArtistRequest request) {
        at.htl.mymusic.entity.Artist a = repository
                .findById((long) request.getId())
                .await()
                .indefinitely();

        return Uni.createFrom().item(() -> {
            return ArtistReply.newBuilder()
                    .setFirstName(a.getFirstName())
                    .setLastName(a.getLastName())
                    .build();
            }
        );
    }
}
