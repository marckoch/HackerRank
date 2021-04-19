package algorithms.sorting;

import base.HackerrankTest;
import org.junit.Test;

/**
 *
 * @author marckoch
 */
public class InsertionSortPart1Test extends HackerrankTest {

    @Test
    public void testMain1() {
        systemInMock.provideLines("5",
                "2 4 6 8 3");

        InsertionSortPart1.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 4 6 8 8",
                "2 4 6 6 8",
                "2 4 4 6 8",
                "2 3 4 6 8");
    }

    @Test
    public void testSample1() {
        systemInMock.provideLines("14",
                "1 3 5 9 13 22 27 35 46 51 55 83 87 23");

        InsertionSortPart1.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("1 3 5 9 13 22 27 35 46 51 55 83 87 87",
                "1 3 5 9 13 22 27 35 46 51 55 83 83 87",
                "1 3 5 9 13 22 27 35 46 51 55 55 83 87",
                "1 3 5 9 13 22 27 35 46 51 51 55 83 87",
                "1 3 5 9 13 22 27 35 46 46 51 55 83 87",
                "1 3 5 9 13 22 27 35 35 46 51 55 83 87",
                "1 3 5 9 13 22 27 27 35 46 51 55 83 87",
                "1 3 5 9 13 22 23 27 35 46 51 55 83 87");
    }

    @Test
    public void testSample2() {
        systemInMock.provideLines("10",
                "2 3 4 5 6 7 8 9 10 1");

        InsertionSortPart1.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 3 4 5 6 7 8 9 10 10",
                "2 3 4 5 6 7 8 9 9 10",
                "2 3 4 5 6 7 8 8 9 10",
                "2 3 4 5 6 7 7 8 9 10",
                "2 3 4 5 6 6 7 8 9 10",
                "2 3 4 5 5 6 7 8 9 10",
                "2 3 4 4 5 6 7 8 9 10",
                "2 3 3 4 5 6 7 8 9 10",
                "2 2 3 4 5 6 7 8 9 10",
                "1 2 3 4 5 6 7 8 9 10");
    }

    @Test
    public void testSample3() {
        systemInMock.provideLines("101",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 301 305 310 312 279");

        InsertionSortPart1.main(null);

        assertThatSystemOutEqualsIgnoreWhiteSpace("2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 301 305 310 312 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 301 305 310 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 301 305 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 301 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 297 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 295 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 291 291 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 289 289 291 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 285 285 289 291 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 284 284 285 289 291 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 280 280 284 285 289 291 295 297 301 305 310 312",
                "2 4 8 12 15 19 21 24 26 29 30 32 35 36 41 44 49 52 57 58 59 64 65 68 73 77 80 82 85 88 93 97 101 105 108 111 115 118 122 127 130 131 132 134 135 136 138 141 144 146 151 153 158 160 165 169 171 176 179 184 187 190 194 197 200 205 210 215 217 222 225 230 231 236 239 243 244 246 248 253 254 256 258 262 263 267 272 274 277 279 280 284 285 289 291 295 297 301 305 310 312");
    }
}
