// 이름을 지정한 내보내기

// PI 이름으로 내보내기
export const PI: number = 3.14 

// getArea 이름으로 내보내기
export const getArea = (radius: number) => PI * Math.pow(radius, 2);

//여러개를 하나로 모아서 내보내기

interface FeatureType {
  add : (a: number, b:number) => number
  sub : (a: number, b:number) => number
}

export const feature: FeatureType = {
  add: (a,b) => a+b,
  sub: (a,b) => a-b
}
