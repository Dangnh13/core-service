const wlSite = "wl-site";
const assets = [
    "/"
];

self.addEventListener("install", installEvent => {
    installEvent.waitUntil(
        caches.open(wlSite).then(cache => {
            cache.addAll(assets);
        })
    );
});

self.addEventListener("fetch", fetchEvent => {
    fetchEvent.respondWith(
        caches.match(fetchEvent.request).then(res => {
            return res || fetch(fetchEvent.request);
        })
    );
});