package com.hiroshisasmita.videogamesapp.presentation.model

import com.hiroshisasmita.videogamesapp.presentation.common_component.GameItem

data class GameUiModel(
    override val title: String,
    override val releaseDate: String,
    override val rating: String,
    override val imageUrl: String,
    val publisher: String,
    val countPlayed: Long,
    val description: String
): GameItem {
    companion object {
        fun createDummy(): List<GameUiModel> {
            return listOf(
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "GTA V - Grand Theft Auto V",
                    releaseDate = "2012-08-02",
                    rating = "4.7",
                    imageUrl = "https://www.najjarlebanon.com/wp-content/uploads/2022/04/gta5.jpg",
                    publisher = "Rockstar Games",
                    countPlayed = 10_000,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                ),
                GameUiModel(
                    title = "Fifa 2023",
                    releaseDate = "2022-05-10",
                    rating = "4.5",
                    imageUrl = "https://images.tokopedia.net/img/cache/700/VqbcmM/2022/9/29/93171ade-3ab7-4bb8-8bc8-67686f989bbd.png",
                    publisher = "EA GAmes",
                    countPlayed = 8_900,
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam ornare ac lacus ut dignissim. Nullam malesuada id dui eget lacinia. Fusce tincidunt placerat dignissim. Nulla eu nisl eget quam consequat lobortis in at diam. Nunc eleifend, leo non auctor tempus, est purus accumsan urna, sed pharetra sem libero condimentum libero. In sagittis aliquet nunc, vitae faucibus est tincidunt quis. Praesent convallis commodo sapien, quis fringilla tortor pharetra in. Suspendisse sit amet pulvinar nibh. Phasellus id erat tincidunt, varius nulla ut, placerat risus. Vivamus non luctus ante, nec cursus nulla. Nam pellentesque pellentesque auctor."
                )
            )
        }
    }
}
